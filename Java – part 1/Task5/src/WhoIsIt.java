import javax.sound.midi.Soundbank;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhoIsIt {
    public static void main(String[] args) {
        String name = "Artsem";
        String lName = "Ilyayeu";
        String resName = "******";
        String resLName = "*******";
        String fullName = name + " "+lName;

        String str;
        List<String> words = new ArrayList<>();
        System.out.println("Введите букву или слово");
        while (true){
            Scanner scan = new Scanner(System.in);
            str = scan.nextLine();
            if (str.length()<1 || str.contains(" ")){
                System.out.println("\u001B[31m" + "Строка пуста или содержит пробел, введите букву или слово"+"\u001B[31m");
            }
            else if(isLetters(str)!=true){
                System.out.println("\u001B[31m" + "Данные не верны, введите букву или слово"+"\u001B[31m");
            }
            else {
                if (words.contains(str)){
                    System.out.println("Строка уже вводилась");
                } else {
                    words.add(str);
                    if (str.length()>1){
                        if(str.equalsIgnoreCase("artsem")){
                            resName = "Artsem";
                            System.out.println("Вы угадали: "+resName+" "+resLName);
                        }
                        else if (str.equalsIgnoreCase("ilyayeu")){
                            resLName = "Ilyayeu";
                            System.out.println("Вы угадали: "+resName+" "+resLName);
                        }
                        else {
                            System.out.println("Вы не угадали");
                        }
                    }
                    else{
                        if (fullName.contains(str.toLowerCase()) || fullName.contains(str.toUpperCase())){
                            for(int i = 0; i<name.length(); i++){
                                if(name.substring(i,i+1).equalsIgnoreCase(str)){
                                    String res = resName.substring(0,i)+str+resName.substring(i+1);
                                    resName = res;

                                }
                            }
                            for(int i = 0; i<lName.length(); i++){
                                if(lName.substring(i,i+1).equalsIgnoreCase(str)){
                                    String res = resLName.substring(0,i)+str+resLName.substring(i+1);
                                    resLName = res;
                                }
                            }
                            System.out.println("Вы угадали: "+resName+" "+resLName);
                        }
                        else{
                            System.out.println("Вы не угадали");
                        }

                    }
                }

            }
            String fullResult = resName + " " + resLName;
            if (fullName.equalsIgnoreCase(fullResult)){
                System.out.println("Поздравляю, вы отгадали: "+ fullResult);
                break;
            }
        }

    }

    static boolean isLetters(String s) throws NumberFormatException {
        if (s.matches("^[a-zA-Z]+$")) return true;
        else  return false;
    }


}
