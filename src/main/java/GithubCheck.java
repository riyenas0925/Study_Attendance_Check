import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;

import java.io.IOException;
import java.util.*;

public class GithubCheck {
    private static final String githubToken = "";

    public static void main(String[] args) throws IOException {
        GithubApi gitHubApi = new GithubApi();
        gitHubApi.connect(githubToken);

        // 출석체크
        List<Attendance> userAttendanceCheck = new ArrayList<>();
        Set<String> allDates = new LinkedHashSet<>();
        List<GHIssue> allIssues = gitHubApi.getAllIssueList();

        for(GHIssue issue : allIssues) {
            allDates.add(issue.getTitle());
            for(GHIssueComment comment : issue.getComments()) {
                String userId = comment.getUser().getLogin();
                String userName = comment.getUser().getName();
                String date = issue.getTitle();

                Optional<Attendance> attendance = userAttendanceCheck.stream()
                        .filter(userAttendance -> userAttendance.getId().equals(userId))
                        .findAny();

                if(attendance.isEmpty()) {
                    userAttendanceCheck.add(new Attendance(userId, userName, new AttendanceDate(date, AttendanceStatus.ATTENDANCE)));
                } else {
                    attendance.get().addAttendanceStatus(new AttendanceDate(date, AttendanceStatus.ATTENDANCE));
                }
            }
        }

        //출석체크 현황 마크다운 생성
        StringBuilder markdown = new StringBuilder();

        //테이블 헤더
        markdown.append("| ");
        for(String date : allDates) {
            markdown.append(" | " + date);
        }
        markdown.append(" |\n");

        //구분선
        markdown.append("| --- ");
        for(String date : allDates) {
            markdown.append("| --- ");
        }
        markdown.append(" |\n");

        //테이블 바디
        for(Attendance attendance : userAttendanceCheck) {
            markdown.append("| " + attendance.getId() + "(" + attendance.getName() + ")");
            for(String date : allDates) {
                Optional<AttendanceDate> attendanceStatus = attendance.getAttendanceStatuses().stream()
                        .filter(status -> status.getDate().equals(date))
                        .findAny();

                if(attendanceStatus.isEmpty()) {
                    markdown.append(" | " + AttendanceStatus.NO_ATTENDANCE.getIcon());
                } else {
                    markdown.append(" | " + attendanceStatus.get().getStatus().getIcon());
                }
            }
            markdown.append(" |\n");
        }

        System.out.println(markdown);
    }
}
