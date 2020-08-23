from FunctionDecl import FunctionDecl
from LicenseProvider import LicenseProvider
from TypeConverter import TypeConverter
from string import Template
from Utils import to_camel_case, to_pascal_case, to_snake_case


# function name to blacklist, reason
blacklisted_functions = [
    # GOptionGroup is not implemented
    "vips_add_option_entries",
    # VipsOperation is not implemented
    "vips_cache_operation_lookup",
    "vips_cache_operation_add",
    "vips_cache_operation_buildp",
    "vips_cache_operation_build",
]


class FunctionDeclGenerator(object):

    def __init__(self, class_name, prefix):
        self.java_decls = []
        self.jni_bindings = []
        self.class_name = class_name
        self.prefix = prefix
        self.type_converter = TypeConverter()

    def __get_camel_case_name(self, f):
        return to_camel_case(f.get_name()[len(self.prefix):])

    def __create_javadoc(self, f):
        javadoc = f.get_comment()
        if javadoc is None:
            return ""
        javadoc = javadoc.replace(f.get_name(), self.__get_camel_case_name(f))
        javadoc = javadoc.replace("@", "@param ")
        javadoc = javadoc.replace("Returns", "@return")
        javadoc = "\n".join([f"    {line}" for line in javadoc.split("\n") if not line.startswith(" * See also")])
        javadoc = javadoc.replace(":", "")
        return javadoc

    def __generate_java_decl(self, f):
        args = []
        for arg in f.get_params():
            java_type = self.type_converter.convert_to_java(arg.type)
            args.append(f"{java_type} {to_camel_case(arg.name)}")
        args = ", ".join(args)
        fname = self.__get_camel_case_name(f)
        ret_type = self.type_converter.convert_to_java(f.get_ret_type())
        javadoc = self.__create_javadoc(f)
        if javadoc != "":
            javadoc = javadoc + "\n"
        self.java_decls.append(f"{javadoc}    public static native {ret_type} {fname}({args});")

    def __generate_jni_binding(self, f):
        args = []
        args_call = []
        before_call = []
        has_arg_string = False
        ret_type = self.type_converter.convert_to_jni(f.get_ret_type())
        for arg in f.get_params():
            arg_call_name = arg.name
            jni_type = self.type_converter.convert_to_jni(arg.type)
            if jni_type == "jstring":
                has_arg_string = True
                arg_call_name = f"c{arg.name}"
                before_call.append(f"    char *{arg_call_name} = (*env)->GetStringUTFChars(env, {arg.name}, NULL);")
            args.append(f"{jni_type} {arg.name}")
            args_call.append(arg_call_name)
        args = ", ".join(args)
        args_call = ", ".join(args_call)
        if (len(args) > 0):
            args = f", {args}"
        fname = self.__get_camel_case_name(f)
        call = f"{f.get_name()}({args_call});"
        if ret_type == "jstring":
            before_call.append(f"    char *cret = NULL;")
            call = f"    cret = {call}" + "\n\n    return (*env)->NewStringUTF(env, cret);"
        elif ret_type == "void":
            call = f"    {call}"
        else:
            call = f"    return {call}"
        env_attribute = "" if has_arg_string else "__attribute__((unused)) "
        if len(before_call) > 0:
            call = "    \n".join(before_call) + "\n\n" + call
        self.jni_bindings.append(f"""JNIEXPORT {ret_type} JNICALL
Java_com_criteo_vips_{self.class_name}_{fname}({env_attribute}JNIEnv *env, __attribute__((unused)) jclass obj{args})
{{
{call}
}}
        """)

    def parse(self, c):
        if not c.kind.is_declaration():
            return
        for t in c.get_tokens():
            # break if function decl is found before the "static" keyword
            if t.spelling == c.spelling:
                break
            # ignore static function
            if t.spelling == "static":
                return
        f = FunctionDecl(c)
        if f.get_name() in blacklisted_functions:
            return
        try:
            self.__generate_java_decl(f)
            self.__generate_jni_binding(f)
        except RuntimeError as err:
            raise RuntimeError(f"{f.get_name()}: {err}")

    def write_bindings(self):
        sep = "\n\n"
        self.__write_bindings("java", sep.join(self.java_decls))
        self.__write_bindings("c", sep.join(self.jni_bindings))

    def __write_bindings(self, ext, functions):
        with open(f"template/VipsTemplate.{ext}", "r", encoding="utf-8") as infile:
            with open(f"{self.class_name}.{ext}", "w", encoding="utf-8") as outfile:
                src = Template(infile.read())
                src = src.substitute({"license": LicenseProvider().get(
                ), "functions": functions, "name": self.class_name})
                outfile.write(src)
