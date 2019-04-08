-module(foo).
-export([new/3, print/1]).


new(IntValue, StrValue, ListValue) ->
    {foo, IntValue, StrValue, ListValue}.


print(Foo) ->
    case Foo of
        {foo, IntValue, StrValue, ListValue} -> 
            io:format("INT: ~w~nSTRING: ~s~nLIST: ~w~n", [IntValue, StrValue, ListValue]);
        _ -> 
            throw({error, "That is not a foo term"})
    end.

