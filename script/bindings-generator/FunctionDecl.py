class FunctionParam(object):
    def __init__(self, name, type):
        self.name = name
        self.type = type

    def __repr__(self):
        return f"{self.type} {self.name}"


class FunctionDecl(object):
    def __init__(self, cursor):
        self.cursor = cursor

    def get_name(self):
        return self.cursor.spelling

    def get_ret_type(self):
        return self.cursor.result_type.spelling

    def get_params(self):
        params = []
        for arg in self.cursor.get_arguments():
            # arg.type.spelling convert gboolean to int, rebuild FunctionParam
            # from tokens
            tokens = [ext.spelling for ext in arg.get_tokens()]
            arg_name = tokens[len(tokens) - 1]
            arg_type = " ".join(tokens[:-1])
            params.append(FunctionParam(arg_name, arg_type))
        return params

    def get_comment(self):
        return self.cursor.raw_comment

    def __str__(self):
        return f"{self.get_ret_type()} {self.get_name()} {self.get_params()}"
