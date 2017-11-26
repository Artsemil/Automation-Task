import java.util.Comparator;

public class ResultComparator implements Comparator<Runner>{
    @Override
    public int compare(Runner o1, Runner o2) {
        return o1.getResult() - o2.getResult();
    }
}
