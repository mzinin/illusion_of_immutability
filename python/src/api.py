from foo import Foo


class Api():
    def __init__(self):
        self.__foo = Foo(42, 'Fish', [0, 1, 2, 3])

    def get_foo(self):
        return self.__foo
