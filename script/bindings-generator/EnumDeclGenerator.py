from EnumDecl import EnumDecl
from LicenseProvider import LicenseProvider
from string import Template


class EnumDeclGenerator(object):
    def __init__(self, enum):
        self.enum = enum

    def write_bindings(self):
        with open("template/Enum.java", "r", encoding="utf-8") as infile:
            with open(f"{self.enum.name}.java", "w", encoding="utf-8") as outfile:
                if not self.enum.comment:
                    comment = ""
                else:
                    # Indent comment
                    comment = f"    {self.enum.comment}"
                    comment = comment.replace("\n", "\n    ")
                    comment += "\n"
                values = ""
                for v in self.enum.values:
                    values += f"    {v.java_name}({v.value}),\n"
                values = values[:-2]
                src = Template(infile.read())
                src = src.substitute(
                    {
                        "license": LicenseProvider().get(),
                        "values": values,
                        "name": self.enum.name,
                        "comment": comment})
                outfile.write(src)
