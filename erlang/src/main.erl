-module(main).
-export([start/0]).


start() ->
    ApiForGoodConsumer = api:new(),
    good_consumer(api:get_foo(ApiForGoodConsumer)),
    io:format("*** After good consumer ***~n"),
    foo:print(api:get_foo(ApiForGoodConsumer)),
    io:format("~n"),

    ApiForEvilConsumer = api:new(),
    evil_consumer(api:get_foo(ApiForEvilConsumer)),
    io:format("*** After evil consumer ***~n"),
    foo:print(api:get_foo(ApiForEvilConsumer)),

    init:stop().


good_consumer(_) ->
    done.


evil_consumer(Foo) ->
    _ = setelement(1, Foo, 7),
    _ = setelement(2, Foo, "James Bond").
