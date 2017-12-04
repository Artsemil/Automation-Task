package Calculator;

import Exceptions.SymbolEnterException;

import java.util.Scanner;

public class ConsoleReader {
    private String operator;
    private double number1;
    private double number2;

    public double enterNumber() throws SymbolEnterException {
        double number;
        System.out.println("Введите число. Для выхода введите quit");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if (str.equals("quit")){
                throw new SymbolEnterException("Число не было введено");
            }
            else if (isNumber(str)==true) {
                number = Double.parseDouble(str);
                break;
            }
            System.out.println("Число введено не верно, введите число повторно. Для выхода введите quit");
        }
        return number;
    }

    public String enterOperator() throws SymbolEnterException {
        String operator;
        System.out.println("Введите операцию. Операция может содержать символы +,-,*,/");
        while(true){
            Scanner operation = new Scanner(System.in);
            operator = operation.next();
            if (operator.equals("quit")){
                throw new SymbolEnterException("Символ не был введен");
            }
            else if (isOperation(operator)){
                break;
            }
            System.out.println("Операция может содержать символы +,-,*,/. Для выхода введите quit");
        }
        return operator;
    }

    private boolean isNumber(String str) {
        if (str.matches("^[0-9]*[.]?[0-9]+$")) return true;
        else return false;
    }

    static boolean isOperation(String str) {
        if (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) return true;
        else return false;
    }

    public String getOperator() {
        return operator;
    }

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

}
