package ui;

import handlers.FileHandler;
import python.JavaPythonCommunication;

import javax.swing.*;

public class Calculator extends JFrame {
    private JTextArea taScreen;
    private JPanel jpMain;
    private JPanel jpButtons;
    private JButton btNum7;
    private JButton btNum8;
    private JButton btNum9;
    private JButton btNum4;
    private JButton btNum5;
    private JButton btNum6;
    private JButton btNum1;
    private JButton btNum2;
    private JButton btNum3;
    private JButton btNum0;
    private JButton btSum;
    private JButton btSub;
    private JButton btMult;
    private JButton btDiv;
    private JButton btResult;
    private JButton btOpenBrac;
    private JButton btCloseBrac;
    private JButton btDel;
    private JButton btClear;

    private void writeToScreen(String text) {
        taScreen.append(text);
    }

    private void deleteChar() {
        String currentStr = taScreen.getText();
        currentStr = currentStr.substring(0, currentStr.length() - 1);
        taScreen.setText(currentStr);
    }

    void setup() {
        setContentPane(jpMain);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setVisible(true);

        // Numbers
        btNum0.addActionListener(e -> writeToScreen("0"));
        btNum1.addActionListener(e -> writeToScreen("1"));
        btNum2.addActionListener(e -> writeToScreen("2"));
        btNum3.addActionListener(e -> writeToScreen("3"));
        btNum4.addActionListener(e -> writeToScreen("4"));
        btNum5.addActionListener(e -> writeToScreen("5"));
        btNum6.addActionListener(e -> writeToScreen("6"));
        btNum7.addActionListener(e -> writeToScreen("7"));
        btNum8.addActionListener(e -> writeToScreen("8"));
        btNum9.addActionListener(e -> writeToScreen("9"));

        // Operators
        btSum.addActionListener(e -> writeToScreen("+"));
        btSub.addActionListener(e -> writeToScreen("-"));
        btMult.addActionListener(e -> writeToScreen("*"));
        btDiv.addActionListener(e -> writeToScreen("/"));
        btResult.addActionListener(e -> taScreen.setText(JavaPythonCommunication.getResult(taScreen.getText())));

        // Brackets
        btOpenBrac.addActionListener(e -> writeToScreen("("));
        btCloseBrac.addActionListener(e -> writeToScreen(")"));

        // Text handlers
        btDel.addActionListener(e -> deleteChar());
        btClear.addActionListener(e -> taScreen.setText(""));

        FileHandler.logResult(null, "started the application");
    }

    public Calculator() {
        setup();
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
