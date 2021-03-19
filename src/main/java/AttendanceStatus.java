public enum AttendanceStatus {
    ATTENDANCE(true, ":white_check_mark:"),
    NO_ATTENDANCE(false, ":x:");


    private Boolean status;
    private String icon;

    AttendanceStatus(Boolean status, String icon) {
        this.status = status;
        this.icon = icon;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getIcon() {
        return icon;
    }
}
