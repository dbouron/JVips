from Utils import to_pascal_case


class EnumValue(object):
    def __init__(self, cursor):
        self.name = cursor.spelling
        self.value = cursor.enum_value
        self.java_name = to_pascal_case(self.name)


class EnumDecl(object):
    def __init__(self, cursor):
        self.name = cursor.type.spelling
        self.type = cursor.enum_type.spelling
        self.comment = cursor.raw_comment
        self.values = []
        for v in cursor.get_children():
            self.values.append(EnumValue(v))
        # Determine the longest common prefix
        index = 0
        is_prefix = True
        ref = self.values[0].java_name
        while is_prefix:
            index += 1
            for v in self.values:
                if not v.java_name.startswith(ref[:-len(ref) + 1 + index]):
                    print(f"{v.java_name} {ref[:-len(ref) + 1 + index]} {index}")
                    is_prefix = False
                    break
        # Remove prefix
        for v in self.values:
            v.java_name = v.java_name[index:]
