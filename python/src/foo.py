from read_only_properties import read_only_properties

@read_only_properties('int_value', 'str_value', 'list_value')
class Foo():
    def __init__(self, int_value, str_value, list_value):
        self.int_value = int_value
        self.str_value = str_value
        self.list_value = list_value

    def __str__(self):
        return 'INT: ' + str(self.int_value) + '\n' + \
               'STRING: ' + self.str_value + '\n' + \
               'LIST: ' + str(self.list_value)


# class Foo():
#     def __init__(self, int_value, str_value, list_value):
#         self.__int_value = int_value
#         self.__str_value = str_value
#         self.__list_value = list_value

#     def __str__(self):
#         return 'INT: ' + str(self.__int_value) + '\n' + \
#                'STRING: ' + self.__str_value + '\n' + \
#                'LIST: ' + str(self.__list_value)

#     def int_value(self):
#         return self.__int_value

#     def str_value(self):
#         return self.__str_value

#     def list_value(self):
#         return self.__list_value

