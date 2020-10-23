import argparse
import wget
import tarfile
from os.path import splitext, split, isdir, isfile, join
from os import listdir
import sys
import clang.cindex
from clang.cindex import TypeKind, CursorKind
import re
from Utils import to_pascal_case
from FunctionDeclGenerator import FunctionDeclGenerator
from EnumDecl import EnumDecl
from EnumDeclGenerator import EnumDeclGenerator
from EnumTestGenerator import EnumTestGenerator

DEFAULT_VIPS_VERSION = "8.9.0"

# Define all filenames where we want to genererate the bindings and their
# function name's prefix
function_decl_filenames = {
    "vips-8.9.0/libvips/iofuncs/init.c": "vips_",
    "vips-8.9.0/libvips/iofuncs/threadpool.c": "vips_concurrency_",
    "vips-8.9.0/libvips/iofuncs/cache.c": "vips_cache_"
}

generators = {}

index = clang.cindex.Index.create()


def generate_enum(filename):
    enums = {}
    tu = index.parse(filename, args=["c", "-std=c99"])
    for c in tu.cursor.get_children():
        # Ignore references
        if not c.location.file or c.location.file.name != filename:
            continue
        if c.kind == CursorKind.ENUM_DECL:
            # Enum should start with "Vips" prefix
            if not c.type.spelling.startswith("Vips"):
                continue
            enum = EnumDecl(c)
            enums[enum.name] = enum
            EnumDeclGenerator(enum).write_bindings()
    return enums


def generate_function(filename):
    tu = index.parse(filename, args=["c", "-std=c99"])
    for c in tu.cursor.get_children():
        # Ignore references
        if not c.location.file or c.location.file.name != filename:
            continue
        if c.kind == CursorKind.FUNCTION_DECL and filename in function_decl_filenames:
            class_name = f"vips_{splitext(split(filename)[1])[0]}"
            class_name = to_pascal_case(class_name)
            prefix = function_decl_filenames[filename]
            prefix_re = re.compile(f"\A{prefix}[a-zA-Z0-9].*")
            if not prefix_re.match(c.spelling):
                continue
            if class_name not in generators:
                # Add a parser for this class
                generators[class_name] = FunctionDeclGenerator(
                    class_name, prefix)
            generators[class_name].parse(c)
    for generator in generators.values():
        generator.write_bindings()


def traverse(root):
    files = [join(root, f) for f in listdir(root)]
    filenames = []
    for filename in files:
        if isdir(filename):
            filenames.extend(traverse(filename))
        elif isfile(filename):
            ext = splitext(filename)[1]
            if ext == ".c" or ext == ".h":
                filenames.append(filename.replace("\\", "/"))
    return filenames


def main():
    parser = argparse.ArgumentParser(
        description='Generate Java enumerations from Vips documentation.')
    parser.add_argument(
        'version',
        metavar='x.y.z',
        type=str,
        nargs='?',
        default=DEFAULT_VIPS_VERSION,
        help='Vips version')

    args = parser.parse_args()
    version = args.version

    if not isfile('BindingsGenerator.py'):
        raise Exception(
            "Script must run from the script/bindings-generator directory")

    if not isdir(f"vips-{version}"):
        url = f'https://github.com/libvips/libvips/releases/download/v{version}/vips-{version}.tar.gz'
        tarball = wget.download(url)
        with tarfile.open(tarball) as tf:
            tf.extractall()

    sources = traverse(f"vips-{version}/libvips")
    enums = {}
    for src in sources:
        enums.update(generate_enum(src))
    EnumTestGenerator(enums).write_tests()
    for src in sources:
        generate_function(src)


if __name__ == "__main__":
    main()
