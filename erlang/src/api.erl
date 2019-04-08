-module(api).
-export([new/0, get_foo/1]).


new() ->
    {api, foo:new(42, "Fish", [0, 1, 2, 3])}.


get_foo(Api) ->
    case Api of
        {api, Foo} -> Foo;
        _ -> throw({error, "That is not an api term"})
    end.
