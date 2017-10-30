import java.util.List;
import java.util.Random;

/**
 * Класс для генерации объектов
 */

public class GenerateSoundRecords {
    private List<SoundRecord> soundRecords;
    private Random randomId = new Random(0);
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
        return new SoundRecord(Enums.random(Compositors.class), randomId.nextInt(150), randomLength.nextInt(600),
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

    /**
     * Реализация генерации любых
     * перечислений в виде вложенного
     * класса.
     */
    public static class Enums {
        private static Random random = new Random();

        public static <T extends Enum<T>> T random(Class<T> ec) {
            return random(ec.getEnumConstants());
        }

        public static <T> T random(T[] values) {
            return values[random.nextInt(values.length)];
        }
    }
}
