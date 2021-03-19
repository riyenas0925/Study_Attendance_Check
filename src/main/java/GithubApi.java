import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

public class GithubApi {

    private static final String GH_REPOSITORY_URL = "interface-2021/AMGC";

    private GitHub github;

    public void connect(String token) throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(token).build();
        github.isCredentialValid();
        github.checkApiUrlValidity();
        this.github = github;
    }

    public List<GHIssue> getAllIssueList() throws IOException {
        GHRepository repository = github.getRepository(GH_REPOSITORY_URL);
        return repository.getIssues(GHIssueState.ALL);
    }
}
