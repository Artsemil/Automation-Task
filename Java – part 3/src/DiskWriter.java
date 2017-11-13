import java.util.ArrayList;
import java.util.List;


public class DiskWriter {
    private List<SoundRecord> soundRecords = new ArrayList<>();

    /**
     * Write disk with all songs of compositor
     *
     * @param list       all sound records
     * @param compositor name of compositor
     * @return
     */
    public List<SoundRecord> writeDisk(List<SoundRecord> list, Compositors compositor) {
        for (SoundRecord sr : list) {
            if (sr.getCompositor().equals(compositor)) {
                this.soundRecords.add(sr);
            }
        }
        return this.soundRecords;
    }

    /**
     * @return list of soundrecords
     */
    public List<SoundRecord> getSoundRecords() {
        return soundRecords;
    }

    /**
     * @param list soundrecords
     * @return length of soundrecords
     */
    public int diskLength(List<SoundRecord> list) {
        int length = 0;
        for (SoundRecord sr : list) {
            length = length + sr.getLength();
        }
        return length;
    }

    /**
     * @param list soundrecords
     * @param name name of record
     * @return
     */
    public List<SoundRecord> findByName(List<SoundRecord> list, String name) {
        List<SoundRecord> sortedrec = new ArrayList<>();
        for (SoundRecord sr : list) {
            if (sr.getName().equalsIgnoreCase(name)) {
                sortedrec.add(sr);
            }
        }
        return sortedrec;
    }
}
