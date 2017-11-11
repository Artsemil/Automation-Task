import java.text.DecimalFormat;

public class SoundRecord {
    private Compositors compositor;
    private int id;
    private int length;  // length in seconds
    private String name;
    private double size;  // size in mb

    public SoundRecord(Compositors compositor, int id, int length, String name, double size) {
        this.compositor = compositor;
        this.id = id;
        this.length = length;
        this.name = name;
        this.size = size;
    }

    public Compositors getCompositor() {
        return compositor;
    }

    public void setCompositor(Compositors compositor) {
        this.compositor = compositor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return Sound record in String view
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId()).append(" ")
                .append(this.getCompositor()).append(" ")
                .append(this.getName()).append(" ")
                .append(this.getLength()).append(" ")
                .append(format(this.getSize()));
        return sb.toString();
    }

    /**
     * @param number
     * @return formatted number
     */
    private String format(double number) {
        return new DecimalFormat("#0.00").format(number);
    }
}
