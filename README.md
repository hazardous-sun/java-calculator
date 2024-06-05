# Java Calculator with Python Integration

This project implements a simple calculator application in Java with the ability to evaluate expressions using a Python script.

## Project Structure

The project consists of the following Java classes:

- `Calculator.java`: This class handles the graphical user interface (GUI) of the calculator. It creates a window with buttons for numbers, operators, brackets, and clear/delete functions. It also interacts with other classes to write user input to the screen and evaluate expressions.
- `FileHandler.java`: This class handles file operations for logging and reading results. It provides functions to read from a file, write to a file, and log results with timestamps to an error log file.
- `JavaPythonCommunication.java`: This class bridges communication between the Java application and the Python script. It executes the Python script with the user input and retrieves the evaluated result.

The project also includes a Python script:

- `evaluate_result.py`: This script receives a mathematical expression through command-line arguments and attempts to evaluate it using the eval function. The result is written to a file named "result.txt".

## How it Works

1. The user interacts with the calculator GUI by clicking on buttons.
2. When a number or operator button is clicked, the `Calculator` class calls the `writeToScreen` function to display the input on the screen.
3. When the equal button is clicked, the `Calculator` class calls the `JavaPythonCommunication` class.
4. `JavaPythonCommunication` calls the `evalResult` function, which creates a process to run the `evaluate_result.py` script with the user input as an argument.
5. The Python script attempts to evaluate the expression and writes the result to a file named "result.txt".
6. `JavaPythonCommunication` then reads the contents of "result.txt" and sets it as the calculator's screen display.
7. File operations throughout the process (reading error logs, writing results) are handled by the `FileHandler` class.

## Additional Notes

- The `evaluate_result.py` script uses the eval function, which can be a security risk in some contexts. Consider implementing a safer evaluation method in production environments.
- This project demonstrates basic communication between Java and Python. More robust error handling could be implemented for communication failures.
