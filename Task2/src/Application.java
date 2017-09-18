import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("Art", "Ilyayeu");
        students[1] = new Student("Art", "Ilyayeu");
        students[2] = new Student("Art", "Ilyayeu");
        students[3] = new Student("Art", "Ilyayeu");
        students[4] = new Student("Art", "Ilyayeu");

        int[] result = new int[5];
        Random rand = new Random();

        int sum=0;
        for (int i =0; i<5; i++){
            result[i]= rand.nextInt(5)+1;
            sum = sum + result[i];
        }
        System.out.println(sum/5.0);


    }
}


