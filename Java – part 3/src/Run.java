import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<SoundRecord> records = new ArrayList<>();
        GenerateSoundRecords generator = new GenerateSoundRecords(records);
        generator.addRecord(25);
        for (SoundRecord r : records) {
            System.out.println(r.toString());
        }

        Disk shopen = new Disk();
        shopen.writeDisk(records, Compositors.SHOPEN);
        System.out.println();
        System.out.println("New disk:");
        for (SoundRecord r : shopen.getSoundRecords()) {
            System.out.println(r.toString());
        }
        System.out.println("Disk length: " + shopen.diskLength(shopen.getSoundRecords()));

        System.out.println();
        System.out.println("Sorted disk: ");
        shopen.getSoundRecords().sort(new LengthComparator());
        for (SoundRecord sr : shopen.getSoundRecords()) {
            System.out.println(sr.toString());
        }

        String find = "sonata1";
        System.out.println();
        System.out.println("Find soundrecords: " + find);
        for (SoundRecord sr : shopen.findByName(shopen.getSoundRecords(), find)) {
            System.out.println(sr.toString());
        }
    }
}
