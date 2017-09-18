import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String number1;
        String number2;
        double a;
        double b;
        String operator;
        while (true){

            System.out.println("Введите первое целое число. Для выхода введите quit");
            while(true){
                Scanner first = new Scanner(System.in);
                number1 = first.next();
                if (number1.equals("quit")) break;
                else if (isNumber(number1)==true){
                    break;
                }
                System.out.println("Число введено не верно, введите число повторно:");
            }
            if (number1.equals("quit")) break;
            a = Double.parseDouble(number1);

            System.out.println("Введите операцию:");
            while(true){
                Scanner operation = new Scanner(System.in);
                operator = operation.next();
                if (operator.equals("quit")) break;
                else if (isOperation(operator)==true){
                    break;
                }
                System.out.println("Операция введена не верно. Операция может содержать символы +,-,*,/. Для выхода введите quit");
            }
            if (operator.equals("quit")) break;


            System.out.println("Введите второе целое число. Для выхода введите quit");
            while(true){
                Scanner second = new Scanner(System.in);
                number2 = second.next();
                if (number2.equals("quit")) break;
                else if (isNumber(number2)==true){
                    break;
                }
                System.out.println("Число введено не верно, введите число повторно:");
            }
            if (number2.equals("quit")) break;
            b = Double.parseDouble(number2);

            if (b==0 && operator.equals("/")){
                System.out.println("Деление на 0 невозможно!");
            }
            else {
                double result = colculate(operator, a,b);
                if (result % 1 == 0) {
                    int resultInt = (int)result;
                    System.out.println("Результат: "+resultInt);
                }
                else System.out.println("Результат: "+result);
            }
            System.out.println();

        }

    }

    static boolean isNumber(String str) {
        if (str.matches("^[0-9]*[.]?[0-9]+$") ) return true;
        else return false;
    }

    static boolean isOperation(String str) {
        if (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) return true;
        else return false;
    }

    static double colculate(String operator, double  a, double b) {
        double result=0;
        if (operator.equals("+")){
            result = a+b;
        }
        else if (operator.equals("-")){
            result = a-b;
        }
        else if (operator.equals("*")){
            result = a*b;
        }
        else if (operator.equals("/")){
            result = a/b;
        }
        return result;
    }

}

