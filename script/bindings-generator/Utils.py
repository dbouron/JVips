import re


def to_camel_case(s):
    output = ''.join(x for x in s.title() if x.isalnum())
    return output[0].lower() + output[1:]


def to_pascal_case(s):
    return s.title().replace('_', '')


def to_snake_case(s):
    return '_'.join(re.findall('[A-Z][^A-Z]*', s)).upper()
