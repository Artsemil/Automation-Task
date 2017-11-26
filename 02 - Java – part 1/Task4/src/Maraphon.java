import java.util.*;

public class Maraphon {
    public static void main(String[] args) {

        String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };
        int[] result = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int count = names.length;
        List<Runner> runners = new ArrayList<>();

        for (int i = 0; i<count;i++){
            runners.add(new Runner(names[i], result[i]));
        }

        runners.sort(new ResultComparator());

        for (int i = 0; i<runners.size();i++){
            System.out.println(runners.get(i).getName() + " " + runners.get(i).getResult());
        }

    }

}
