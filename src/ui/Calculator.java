package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private void writeToScreen(String text) {
        taScreen.append(text);
    }

    void setup() {
        setContentPane(jpMain);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setVisible(true);

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

        btSum.addActionListener(e -> writeToScreen("+"));
        btSub.addActionListener(e -> writeToScreen("-"));
        btMult.addActionListener(e -> writeToScreen("*"));
        btDiv.addActionListener(e -> writeToScreen("/"));
        btOpenBrac.addActionListener(e -> writeToScreen("("));
        btCloseBrac.addActionListener(e -> writeToScreen(")"));

        btDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public Calculator() {
        setup();
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
