import java.util.Comparator;

public class LengthComparator implements Comparator<SoundRecord> {
    @Override
    public int compare(SoundRecord o1, SoundRecord o2) {
        return o1.getLength() - o2.getLength();
    }
}
