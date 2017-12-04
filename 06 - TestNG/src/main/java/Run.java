import Calculator.Calculator;
import Calculator.ConsoleReader;
import Exceptions.SymbolEnterException;

public class Run {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        try {
            reader.setNumber1(reader.enterNumber());
            reader.setNumber2(reader.enterNumber());
            reader.setOperator(reader.enterOperator());
            Calculator calculator = new Calculator();
            System.out.println("Результат: "+ calculator.calculate(reader.getNumber1(),reader.getOperator(),reader.getNumber2()));
        }catch (SymbolEnterException e){
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println("Вы пытались поделить на 0!");
        }
    }
}
