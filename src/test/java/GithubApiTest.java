import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GithubApiTest {

    @Test
    @DisplayName("잘못된 TOKEN 일때")
    public void githubInvalidToken() {
        Assertions.assertThrows(IOException.class, () -> {
            String invalidToken = "DUMMYTOKENDUMMYTOKENDUMMYTOKENDUMMYTOKEN";
            GithubApi githubApi = new GithubApi();
            githubApi.connect(invalidToken);
        });
    }

    @Test
    @DisplayName("참여비율 계산")
    public void calculateParticipationRate() {

    }

    @Test
    @DisplayName("열려있는 이슈만 출석체크")
    public void getGithubIssue() {

    }
}
