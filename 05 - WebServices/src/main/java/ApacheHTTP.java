import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class ApacheHTTP {
    public void getContributersLogin(String url, String token) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", token);
        request.addHeader("User-Agent", "chrome");
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        ObjectMapper mapper = new ObjectMapper();
        Contributor[] contributors = new Contributor[0];
        try {
            contributors = mapper.readValue(responseString, Contributor[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < contributors.length; i++) {
            String login = contributors[i].getLogin();
            System.out.println(login);
        }
    }

    public void addCollaborator(String login) throws IOException {
        String url = "https://api.github.com/repos/Artsemil/Automation-Task/collaborators/" + login;
        HttpClient client = new DefaultHttpClient();
        HttpPut request = new HttpPut(url);
        request.addHeader("Authorization", "Basic QXJ0c2VtaWw6bTdtdkRBQw==");
        request.addHeader("User-Agent", "chrome");
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() == 201) {
            System.out.println("Invite has been sent");
        } else System.out.println("Incorrect request");
        System.out.println(response);
    }
}
