import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileEditer {

    public static void write(String fileName, List<SoundRecord> soundRecords) {
        File file = new File(fileName);
        FileWriter fr = null;

        try {
            fr = new FileWriter(file);
            for (SoundRecord sr : soundRecords) {
                fr.write(sr.toString() + System.getProperty("line.separator"));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<SoundRecord> read(String fileName) {
        List<SoundRecord> soundrecords = new ArrayList<>();
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                SoundRecord item = listToSoundRer(line.split("\\s"));
                if (item != null) {
                    soundrecords.add(item);
                } else {
                    System.out.println("Wrong line: " + line);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soundrecords;
    }

    private static SoundRecord listToSoundRer(String[] list) {
        SoundRecord sr = new SoundRecord();
        try {
            sr.setId(Integer.parseInt(list[0]));
            sr.setCompositor(Compositors.valueOf(list[1]));
            sr.setName(list[2]);
            sr.setLength(Integer.parseInt(list[3]));
            NumberFormat format = NumberFormat.getInstance(new Locale("ru"));
            sr.setSize(format.parse(list[4]).doubleValue());
        } catch (ParseException e) {
            return null;
        }
        return sr;
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
