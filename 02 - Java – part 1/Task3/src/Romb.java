import java.util.ArrayList;
import java.util.List;
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
        List<String> line = new ArrayList<>();
        String str;
        int paint1 = size-1;
        int paint2 = 1;
        int paint3 = 1;
        int paint4 = size-2;
        for (int i=0; i<size; i++){
            line.add("");
            str="";
            for (int j=0; j<size; j++){
                if (j==paint1){
                    str= str + star;
                }
                else {
                    str=str+space;
                }
                line.set(i,str);
            }
            paint1--;
        }

        for (int i=1; i<size; i++){
            str="";
            for (int j=1; j<size; j++){
                if (j==paint2){
                    str= str + star;
                }
                else {
                    str=str+space;
                }

            }
            line.set(i,line.get(i)+str);
            paint2++;
        }

        //сторона 3
        for (int i=0; i<size; i++){
            line.add("");
            str="";
            for (int j=0; j<size; j++){
                if (j==paint3){
                    str= str + star;
                }
                else {
                    str=str+space;
                }
                line.set(i+size, str);
            }
            paint3++;
        }

        //сторона 4
        for (int i=1; i<size-1; i++){
            str="";
            for (int j=1; j<size-1; j++){
                if (j==paint4){
                    str= str + star;
                }
                else {
                    str=str+space;
                }

            }
            line.set(size+i-1,line.get(size+i-1)+str);
            paint4--;
        }



        for (String s: line){
            System.out.println(s);
        }

    }



}
