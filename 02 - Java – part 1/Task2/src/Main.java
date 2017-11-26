import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;
        int day;
        System.out.println("Введите номер дня недели от 1 до 7");
        while (true){
            Scanner words = new Scanner(System.in);
            str = words.nextLine();
            if (str.length()<1){
                System.out.println("\u001B[31m" + "Строка пуста, введите номер дня недели от 1 до 7"+"\u001B[31m");
            }
            else if(isDigit(str)!=true){
                System.out.println("\u001B[31m" + "Не верно, введите номер дня недели от 1 до 7"+"\u001B[31m");
            }
            else {
                day = Integer.parseInt(str);
                break;
            }
        }
        printDay(day);

    }

    static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void printDay (int day){
        switch (day){
            case 1:
                System.out.println(DayOfWeek.MONDAY);
                break;
            case 2:
                System.out.println(DayOfWeek.TUESDAY);
                break;
            case 3:
                System.out.println(DayOfWeek.WEDNESDAY);
                break;
            case 4:
                System.out.println(DayOfWeek.THURSDAY);
                break;
            case 5:
                System.out.println(DayOfWeek.FRIDAY);
                break;
            case 6:
                System.out.println(DayOfWeek.SATURDAY);
                break;
            case 7:
                System.out.println(DayOfWeek.SUNDAY);
                break;
            default:
                System.out.println("Такого дня недели не существует");
        }

    }


}
