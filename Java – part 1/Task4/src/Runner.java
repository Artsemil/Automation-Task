public class Runner {
    private String name;
    private int result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Runner (String name, int result){
        this.name = name;
        this.result = result;
    }
}
