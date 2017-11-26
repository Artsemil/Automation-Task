import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        String owner = "Artsemil/";
        String repo = "Automation-Task/";
        String url = "https://api.github.com/repos/"+owner+repo+"contributors";
        String token = "Basic QXJ0c2VtaWw6bTdtdkRBQw==";

        RTemplate restTemplate = new RTemplate();
        restTemplate.getContributersLogin(url, token);
        restTemplate.addCollaborator("sqwaerart");

        System.out.println("------------------------");
        ApacheHTTP apacheHTTP = new ApacheHTTP();
        try {
            apacheHTTP.getContributersLogin(url, token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            apacheHTTP.addCollaborator("sqwaerart");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
