import java.util.LinkedList;
import java.util.List;

public class Attendance {
    private String id;
    private String name;
    private List<AttendanceDate> attendanceDates = new LinkedList<>();

    public Attendance(String id, String name, AttendanceDate... attendanceDates) {
        this.id = id;
        this.name = name;
        for(AttendanceDate attendanceDate : attendanceDates) {
            this.attendanceDates.add(attendanceDate);
        }
    }

    public void addAttendanceStatus(AttendanceDate attendanceDate) {
        this.attendanceDates.add(attendanceDate);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AttendanceDate> getAttendanceStatuses() {
        return attendanceDates;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attendanceDates=" + attendanceDates +
                '}';
    }
}
