from LicenseProvider import LicenseProvider
from string import Template


class EnumTestGenerator(object):
    def __init__(self, enums):
        self.enums = enums

    def write_tests(self):
        with open("template/VipsEnumTest.c", "r", encoding="utf-8") as infile:
            with open(f"VipsEnumTest.c", "w", encoding="utf-8") as outfile:
                tests = ""
                for enum in self.enums.values():
                    tests += f"    // {enum.name}\n"
                    for value in enum.values:
                        tests += f"    assertEqualsNativeEnumValue(env, {value.name}, \"com/criteo/vips/enums/{enum.name}\", \"{value.java_name}\");\n"
                tests = tests[:-1]
                src = Template(infile.read())
                src = src.substitute(
                    {"license": LicenseProvider().get(), "tests": tests})
                outfile.write(src)
