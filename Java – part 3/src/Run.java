import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        int COMPOSISHION_COUNT = 20;

        List<SoundRecord> records = new ArrayList<>();
        GenerateSoundRecords generator = new GenerateSoundRecords(records);
        generator.addRecord(COMPOSISHION_COUNT);
        for (SoundRecord r : records) {
            System.out.println(r.toString());
        }

        DiskWriter shopen = new DiskWriter();
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
        System.out.println("-----------------------");

        //Write and read files from disk
        final String FILENAME = "records.txt";
        FileEditer.write(FILENAME, records);

        List<SoundRecord> readFile = FileEditer.read(FILENAME);
        DiskWriter shopenFromFile = new DiskWriter();
        shopenFromFile.writeDisk(readFile, Compositors.SHOPEN);

        System.out.println("New disk from file:");
        for (SoundRecord r : shopenFromFile.getSoundRecords()) {
            System.out.println(r.toString());
        }
    }
}