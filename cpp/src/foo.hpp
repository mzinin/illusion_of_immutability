#pragma once

#include <iostream>
#include <list>

struct Foo
{
    const int intValue;
    const std::string strValue;
    const std::list<int> listValue;

    Foo(int intValue_, const std::string& strValue_, const std::list<int>& listValue_)     
        : intValue(intValue_)
        , strValue(strValue_)
        , listValue(listValue_)
    {}
};

std::ostream& operator<<(std::ostream& out, const Foo& foo)
{
    out << "INT: " << foo.intValue << "\n";
    out << "STRING: " << foo.strValue << "\n";
    out << "LIST: [";
    for (auto it = foo.listValue.cbegin(); it != foo.listValue.cend(); ++it)
    {
        out << (it == foo.listValue.cbegin() ? "" : ", ") << *it;
    }
    out << "]\n";
    return out;
}

