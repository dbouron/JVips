from string import Template
import datetime

LICENSE_TEMPLATE = "template/LICENSE"


class LicenseProvider(object):
    class __LicenseProvider(object):
        def __init__(self):
            with open(LICENSE_TEMPLATE, 'r', encoding="utf-8") as infile:
                license = Template(infile.read())
                license = license.safe_substitute(
                    {'year': datetime.date.today().year})
            self.license = license

    __instane = None

    def __init__(self):
        if not self.__instane:
            self.__instane = LicenseProvider.__LicenseProvider()

    def get(self):
        return self.__instane.license
