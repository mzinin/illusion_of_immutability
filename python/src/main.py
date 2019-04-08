from api import Api


def good_consumer(foo):
    pass


def evil_consumer(foo):
    # foo.int_value = 7
    # foo.str_value = 'James Bond'
    foo.__dict__['int_value'] = 7
    foo.__dict__['str_value'] = 'James Bond'


def main():
    api = Api()
    good_consumer(api.get_foo())
    print("*** After good consumer ***")
    print(api.get_foo())
    print()

    api = Api()
    evil_consumer(api.get_foo())
    print("*** After evil consumer ***")
    print(api.get_foo())
    print()


if __name__ == '__main__':
    main()
