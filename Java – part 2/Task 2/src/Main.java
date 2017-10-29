import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(15, "Alex", "Petrov", 31));
        students.add(new Student(19, "Alex", "Ivanov", 21));
        students.add(new Student(33, "Alex", "Sidorov", 22));
        students.add(new Student(111, "Alex", "Semenov", 23));
        students.add(new Student(106, "Alex", "Ryabov", 24));
        students.add(new Student(17, "Alex", "Petrov1", 25));
        students.add(new Student(200, "Alex", "Petrov2", 26));
        students.add(new Student(222, "Alex", "Petrov3", 27));
        students.add(new Student(150, "Alex", "Petrov4", 28));
        students.add(new Student(110, "Alex", "Petrov5", 29));

        for (Map.Entry<Integer, Student> map : idMore100(getMap(students)).entrySet()) {
            Student stud = map.getValue();
            System.out.println(map.getKey() + " " +
                    stud.getId() + " " + stud.getLastName() + " " + stud.getAge());
        }
    }

    public static List<Student> ageSort(List<Student> stud) {
        stud.sort(new AgeComparator());
        return stud;
    }

    public static List<Student> searchByLastNameFirstLetter(List<Student> students, char firstLetter) {
        List<Student> findedStudents = new ArrayList<Student>();
        for (Student st : students) {
            if (st.getLastName().charAt(0) == firstLetter) {
                findedStudents.add(st);
            }
        }
        return findedStudents;
    }

    public static double overageAge(List<Student> students) {
        double sumAge = 0;
        int studentAmount = 0;
        for (Student st : students) {
            sumAge = sumAge + st.getAge();
            studentAmount = studentAmount + 1;
        }
        double overageAge = sumAge / studentAmount;
        return overageAge;
    }

    public static Map<Integer, Student> getMap(List<Student> students) {
        Map<Integer, Student> map = new HashMap<>();
        for (Student stud : students) {
            map.put(stud.getId(), stud);
        }
        return map;
    }

    public static Map<Integer, Student> idMore100(Map<Integer, Student> map) {
        Map<Integer, Student> sortedMap = new HashMap<>();
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            if (entry.getKey() > 100) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }
        return sortedMap;
    }
}
