import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class RTemplate {

    public void getContributersLogin(String url, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.set("User-Agent", "chrome");
        HttpEntity<String> httpEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Contributor[] contributors = new Contributor[0];
        try {
            contributors = mapper.readValue(response.getBody(), Contributor[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < contributors.length; i++) {
            String login = contributors[i].getLogin();
            System.out.println(login);
        }
    }

    public void addCollaborator(String login) {
        String url = "https://api.github.com/repos/Artsemil/Automation-Task/collaborators/" + login;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic QXJ0c2VtaWw6bTdtdkRBQw==");
        headers.set("User-Agent", "chrome");
        HttpEntity<String> httpEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        if (response.getStatusCodeValue() == 201) {
            System.out.println("Invite has been sent");
        } else System.out.println("Incorrect request");
    }
}
