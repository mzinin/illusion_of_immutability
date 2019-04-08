#pragma once

#include "foo.hpp"
#include <iostream>


class Api
{
public:
    const Foo& getFoo() const
    {
        return currentFoo;
    }

private:
    const Foo currentFoo = Foo{42, "Fish", {0, 1, 2, 3}};
};

