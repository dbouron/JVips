from Utils import to_camel_case


class EnumValue(object):
    def __init__(self, cursor):
        self.name = cursor.spelling
        self.java_name = to_camel_case(self.name)
        self.value = cursor.enum_value


class EnumDecl(object):
    def __init__(self, cursor):
        self.name = cursor.type.spelling
        self.type = cursor.enum_type.spelling
        self.comment = cursor.raw_comment
        self.values = []
        for v in cursor.get_children():
            self.values.append(EnumValue(v))
