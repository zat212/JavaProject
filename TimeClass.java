public class TimeClass
{
    private String timeSlotCode;
    private String timeSlot;

    public TimeClass()
    {
        super();
    }

    public TimeClass(String timeSlotcode, String timeSlot) {
        this.timeSlotCode = timeSlotcode;
        this.timeSlot = timeSlot;
    }

    public String getTimeSlotCode() {
        return timeSlotCode;
    }

    public void setTimeSlotCode(String timeSlotCode) {
        this.timeSlotCode = timeSlotCode;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "TimeClass{" +
                "timeSlotCode='" + timeSlotCode + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }
}
