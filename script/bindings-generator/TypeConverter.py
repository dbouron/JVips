class TypeConverter(object):
    class __TypeConverter(object):
        def __init__(self):
            # C types to (Java, C JNI)
            self.c_type_conversions = {
                "gboolean": ("boolean", "jboolean"),
                "int": ("int", "jint"),
                "const char *": ("String", "jstring"),
                "void": ("void", "void"),
                "size_t": ("long", "jlong")
            }

    __instane = None

    def __init__(self):
        if not self.__instane:
            self.__instane = TypeConverter.__TypeConverter()

    def __convert(self, type):
        if type not in self.__instane.c_type_conversions:
            raise RuntimeError(f"{type} hasn't equivalent")
        return self.__instane.c_type_conversions[type]

    def convert_to_java(self, type):
        java_type, _ = self.__convert(type)
        return java_type

    def convert_to_jni(self, type):
        _, jni_type = self.__convert(type)
        return jni_type
