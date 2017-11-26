import java.util.List;
import java.util.Random;

/**
 * Класс для генерации объектов
 */

public class GenerateSoundRecords {
    private List<SoundRecord> soundRecords;
    private Random randomId = new Random();
    private Random randomLength = new Random(80);

    /**
     * Constructor
     *
     * @param soundRecords empty collection of soundrecords
     */
    public GenerateSoundRecords(List<SoundRecord> soundRecords) {
        this.soundRecords = soundRecords;
    }

    private SoundRecord getRecord() {
        return new SoundRecord(Compositors.getRandom(), randomId.nextInt(50), randomLength.nextInt(600),
                "sonata" + randomId.nextInt(5), 10 + Math.random() * 40);
    }

    /**
     * Add number of soundrecords
     *
     * @param countOfRecords amount of soundrecords
     */
    public void addRecord(int countOfRecords) {
        for (int i = 0; i < countOfRecords; i++) {
            soundRecords.add(getRecord());
        }
    }
}
