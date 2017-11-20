import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Contributor {
    private String login;

    public String getLogin() {
        return login;
    }
}
