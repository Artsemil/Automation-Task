package Calculator;

public class Calculator implements PrimitiveCalculator {

    public double calculate(double a, String o, double b) {
        double result = 0;
        if (o.equals("+")) {
            result = add(a,b);
        }
        if (o.equals("-")) {
            result = sub(a,b);
        }
        if (o.equals("*")) {
            result = mul(a,b);
        }
        if (o.equals("/")) {
            result = div(a,b);
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

    public double div(double a, double b) {
        return a / b;
    }
}
