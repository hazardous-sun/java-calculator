package python;

import handlers.FileHandler;

import java.io.IOException;

public class JavaPythonCommunication {
    private static void evalResult(String input) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "src/python/evaluate_result.py", input);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            FileHandler.logResult(null, "Passed values to evaluate_result.py");
            process.waitFor();
            FileHandler.logResult(null, "evaluate_result.py ran without errors");
        } catch (IOException | InterruptedException e) {
            FileHandler.logResult(e, e.getMessage());
        }
    }
    public static String getResult(String input) {
        evalResult(input);
        FileHandler.logResult(null, "evaluated result");
        return FileHandler.readFile("result.txt");
    }
}
