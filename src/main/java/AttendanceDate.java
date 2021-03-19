public class AttendanceDate {
    private String date;
    private AttendanceStatus status;

    public AttendanceDate(String date, AttendanceStatus status) {
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AttendanceStatus{" +
                "date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
