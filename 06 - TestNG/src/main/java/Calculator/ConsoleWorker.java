package Calculator;

import Exceptions.SymbolEnterException;

import java.util.Scanner;

public class ConsoleWorker {

    public double enterNumber() throws SymbolEnterException {
        double number;
        System.out.println("Введите число. Для выхода введите quit");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if (str.equals("quit")) {
                throw new SymbolEnterException("Число не было введено");
            } else if (isNumber(str)) {
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
        while (true) {
            Scanner operation = new Scanner(System.in);
            operator = operation.next();
            if (operator.equals("quit")) {
                throw new SymbolEnterException("Символ не был введен");
            } else if (isOperation(operator)) {
                break;
            }
            System.out.println("Операция может содержать символы +,-,*,/. Для выхода введите quit");
        }
        return operator;
    }

    private boolean isNumber(String str) {
        return str.matches("^[0-9]*[.]?[0-9]+$");
    }


    private boolean isOperation(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

}
