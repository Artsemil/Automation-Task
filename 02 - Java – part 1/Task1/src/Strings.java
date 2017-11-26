import java.util.Scanner;

public class Strings {
    public static void main(String[] args){
        String str;
        do{
            Scanner words = new Scanner(System.in);
            str = words.nextLine();
            if (str.length()<1){
                System.out.println("\u001B[31m" + "Строка пуста, введите строку снова"+"\u001B[31m");
            }
        } while (str.length()<1);

        System.out.println("1)" + toOmonim(str));
        System.out.println("2)");
        toWords(str);
        System.out.println("3)" + spacesToStars(str));
        System.out.println("4)" + str.toUpperCase());
        System.out.println("5)" + fiveToTen(str));
    }

    static String toOmonim(String str){
        String omonim = "";
        for (int i = str.length()-1; i>=0; i--){
            char a = str.charAt(i);
            omonim = omonim + a;
        }
        return omonim;
    }

    static void toWords(String str){
        String parsedStr = str.trim();
        if (parsedStr.length()<1) return;
        parsedStr = parsedStr + " ";
        String strNew = "";
        for (int i = 0; i<parsedStr.length(); i++){
            char a = parsedStr.charAt(i);
            if(a ==' '){
                if (parsedStr.charAt(i-1)==' '){
                    continue;
                }
                else {
                    System.out.println(strNew);
                    strNew = "";
                }
            }
            else {
                strNew = strNew +a;
            }
        }
    }

    static String spacesToStars(String str){
        String strNew = "";
        for (int i = 0; i<str.length(); i++){
            char a = str.charAt(i);
            if(a ==' '){
                strNew = strNew + "*";
            }
            else {
                strNew = strNew + a;
            }
        }
        return strNew;
    }

    static String fiveToTen(String str){
        if (str.length()<10){
             return "\u001B[31m" + "Длина строки меньше 10 символов"+"\u001B[31m";
        }
        else return str.substring(5,10);
    }

}
