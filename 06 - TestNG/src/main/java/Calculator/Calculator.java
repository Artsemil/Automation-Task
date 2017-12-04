package Calculator;

public class Calculator {

    public double calculate(double a, double b, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = add(a, b);
                break;
            case "-":
                result = sub(a, b);
                break;
            case "*":
                result = mul(a, b);
                break;
            case "/":
                result = div(a, b);
                break;
        }
        return result;
    }


    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) throws NullPointerException {
        if (b == 0) throw new NullPointerException();
        return a / b;
    }
}
