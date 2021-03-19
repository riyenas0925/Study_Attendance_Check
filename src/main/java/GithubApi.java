import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

public class GithubApi {

    private static final String GH_REPOSITORY_URL = "riyenas0925/Study_Attendance_Check";

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

    public GHCommit commit(String msg, String commitBranch) throws IOException {
        GHRepository repository = github.getRepository(GH_REPOSITORY_URL);
        GHBranch branch = repository.getBranch(commitBranch);
        GHTreeBuilder treeBuilder = repository.createTree().baseTree(branch.getSHA1());
        return repository.createCommit()
                .tree(treeBuilder.create().getSha())
                .parent(branch.getSHA1()).message(msg).create();
    }

    public void push() {

    }
}
