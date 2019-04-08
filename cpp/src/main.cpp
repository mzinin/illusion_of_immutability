#include "api.hpp"
#include "foo.hpp"

#include <list>


namespace
{
    void goodConsumer(const Foo& foo)
    {
        // do nothing wrong with foo
    }

    // void stupidConsumer(const Foo& foo)
    // {
    //     foo.listValue.push_back(100);
    // }

    void evilConsumer(const Foo& foo)
    {
        const_cast<int&>(foo.intValue) = 7;
        const_cast<std::string&>(foo.strValue) = "James Bond";

        // auto& mutableIntValue = reinterpret_cast<int&>(api.getFoo().intValue);  // WON'T COMPILE
        // auto& mutableIntValue = (int&)(api.getFoo().intValue);  
    }

    void evilSubConsumer(const std::string& value)
    {
        const_cast<std::string&>(value) = "Loki";
    }

    void goodSubConsumer(const std::string& value)
    {
        evilSubConsumer(value);
    }

    void evilCautiousConsumer(const Foo& foo)
    {
        const auto& strValue = foo.strValue;
        goodSubConsumer(strValue);
    }
}

int main()
{
    {
        const auto& api = Api();
        goodConsumer(api.getFoo());
        std::cout << "*** After good consumer ***\n";
        std::cout << api.getFoo() << std::endl;
    }

    {
        const auto& api = Api();
        evilConsumer(api.getFoo());
        std::cout << "*** After evil consumer ***\n";
        std::cout << api.getFoo() << std::endl;
    }

    {
        const auto& api = Api();
        evilCautiousConsumer(api.getFoo());
        std::cout << "*** After evil but cautious consumer ***\n";
        std::cout << api.getFoo() << std::endl;
    }
}

