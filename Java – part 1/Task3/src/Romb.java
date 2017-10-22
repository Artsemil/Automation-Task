import java.util.Scanner;

public class Romb {
    public static void main(String[] args) {
        String str;
        int size;
        while (true){
            Scanner words = new Scanner(System.in);
            str = words.nextLine();
            if (str.length()<1){
                System.out.println("\u001B[31m" + "Строка пуста, введите число снова"+"\u001B[31m");
            }
            else if(isDigit(str)!=true){
                System.out.println("\u001B[31m" + "Введено не число, введите число снова"+"\u001B[31m");
            }
            else {
                size = Integer.parseInt(str);
                break;
            }
        }

        paintRomb(size);
    }

    static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void paintRomb(int size){
        String space = " ";
        String star = "*";
        String str = "";
        for (int i=0; i<size; i++){
            for (int j=i; j<size-1; j++){
                str = str + space;
            }
            System.out.println(str + star);
            str = "";
        }
    }



}
