import sys


def calculate(input_str):
    try:
        return str(eval(input_str))
    except NameError:
        return "NameError: Be sure that the numbers and operators are in order"


def write_to_result():
    file = open("result.txt", "w")
    result = ""
    match len(sys.argv):
        case 1:
            result = "SyntaxError: No parameters passed"
        case _:
            result = calculate(sys.argv[1])
    file.write(result)
    file.close()


if __name__ == "__main__":
    write_to_result()
