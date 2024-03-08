package python;

import handlers.FileHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaPythonCommunication {
    private static String evalResult(String input) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "evaluate_result.py", input);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            process.waitFor();
            FileHandler.logResult(null, "Passed values to evaluate_result.py");
            return reader.readLine();
        } catch (IOException | InterruptedException e) {
            FileHandler.logResult(e, e.getMessage());
            return "ERROR: " + e.getMessage();
        }
    }
    public static String getResult(String input) {
        String result = evalResult(input);
        FileHandler.writeFile(result, "evaluate_result.py", false);
        return FileHandler.readFile("evaluate_result.py");
    }
}
