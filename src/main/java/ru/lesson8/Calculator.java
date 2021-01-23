package ru.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame {
    private final JTextField text = new JTextField(14);

    public Calculator() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 190, 300);
        setResizable(false);

        JPanel panel = new JPanel();
        text.setEditable(false);
        panel.add(text);

        JButton[] btns = new JButton[9];
        for (int i = 0; i < 9; i++) {
            btns[i] = new JButton(String.valueOf(i + 1));
            btns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickNumber(e);
                }
            });
            panel.add(btns[i]);
        }
        JButton btnZero = new JButton("0");
        JButton btnMinus = new JButton("-");
        JButton btnPlus = new JButton("+");
        JButton btnMulti = new JButton("*");
        JButton btnDev = new JButton("/");
        JButton btnTotal = new JButton("=");
        JButton btnDot = new JButton(".");
        JButton btnPow = new JButton("^");
        btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });

        btnPow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });
        btnMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });
        btnDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });
        btnDev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickNumber(e);
            }
        });

        btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalResult();
            }
        });
        panel.add(btnMinus);
        panel.add(btnZero);
        panel.add(btnPlus);
        panel.add(btnMulti);
        panel.add(btnTotal);
        panel.add(btnDev);
        panel.add(btnDot);
        panel.add(btnPow);
        add(panel);
        setVisible(true);
    }


    public void clickNumber(ActionEvent e) {
        String currentText = text.getText();
        String currentButton = e.getActionCommand();
        if(currentButton.equals("^") || currentButton.equals("+") || currentButton.equals("-") || currentButton.equals("/") || currentButton.equals("*") || currentButton.equals(".")){
            if(currentText.length()>0){
                char[] currentTextChar = currentText.toCharArray();
                char lastChar = currentTextChar[currentTextChar.length-1];
                if(lastChar != '^' && lastChar != '+' && lastChar != '-' && lastChar != '/' && lastChar != '*' && lastChar != '.'){
                    text.setText(text.getText() + e.getActionCommand());
                }
            }
        }
        else{
            text.setText(text.getText() + e.getActionCommand());
        }
    }

    public void totalResult(){
        String str = new String(text.getText());
        ArrayList<Double> digits = new ArrayList<Double>();
        ArrayList<Character> sign = new ArrayList<Character>();
        String currentDigit = "";

        for(char c: str.toCharArray()){
            if(c != '-' && c != '+' && c != '*' && c != '/' && c != '^'){
                currentDigit += c;
                System.out.println(currentDigit);
            }
            else if(c == '^'){
                digits.add(Double.valueOf(currentDigit));
                digits.add(Double.valueOf(currentDigit));
                currentDigit = "";
                sign.add('*');
            }
            else{
                digits.add(Double.valueOf(currentDigit));
                currentDigit = "";
                sign.add(c);
            }
        }
        if(currentDigit != ""){
            digits.add(Double.valueOf(currentDigit));
        }

        while(sign.indexOf('*') >= 0 || sign.indexOf('/') >= 0){
            for(int i = 0; i < sign.size(); i++){
                if(sign.get(i) == '*'){
                    double res = Double.valueOf(digits.get(i))*digits.get(i+1);
                    sign.remove(i);
                    digits.remove(i+1);
                    digits.remove(i);
                    digits.add(i, res);
                    break;
                } else if(sign.get(i) == '/'){
                    double res = Double.valueOf(digits.get(i))/digits.get(i+1);
                    sign.remove(i);
                    digits.remove(i+1);
                    digits.remove(i);
                    digits.add(i, res);
                    break;
                }
            }
        }

        double total = digits.get(0);
        for(int i = 0; i < sign.size(); i++){
            if(sign.get(i) == '+'){
                total += Double.valueOf(digits.get(i+1));
            } else if(sign.get(i) == '-'){
                total -= Double.valueOf(digits.get(i+1));
            }
        }
        text.setText(String.valueOf(total));
    }


}
