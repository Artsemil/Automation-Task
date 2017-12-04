import Calculator.Calculator;
import Calculator.ConsoleWorker;
import Exceptions.SymbolEnterException;

public class Run {
    public static void main(String[] args) {
        ConsoleWorker worker = new ConsoleWorker();
        try {
            double firstNumber = worker.enterNumber();
            double secondNumber = worker.enterNumber();
            String operator = worker.enterOperator();
            Calculator calculator = new Calculator();
            System.out.println("Результат: " + calculator.calculate(firstNumber, secondNumber, operator));
        } catch (SymbolEnterException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Вы пытались поделить на 0!");
        }
    }
}
