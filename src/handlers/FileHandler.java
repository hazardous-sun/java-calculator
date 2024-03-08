package handlers;

import java.io.*;
import java.time.LocalTime;

public class FileHandler {
    public static String readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            logResult(e, e.getMessage());
            return null;
        }
    }

    public static void writeFile(String input, String filePath, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(input);
            if (append) {
                writer.newLine();
            }
        } catch (IOException e) {
            logResult(e, e.getMessage());
        }
    }

    public static void logResult(Exception e, String text) {
        String result;
        if (e == null) {
            result = "SUCCESS";
        } else {
            result = e.getClass().toString();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("../errors.log", true))) {
            writer.write(result + ": " + LocalTime.now() + " - " + text);
            writer.newLine();
        } catch (IOException ex) {
            logResult(ex, ex.getMessage());
        }
    }
}
