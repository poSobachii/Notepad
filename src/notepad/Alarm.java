package notepad;

import java.time.LocalTime;

public class Alarm extends Note implements Expired {

    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Alarm{ #" + getId() +
                ", text='" + getText() + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return time.isBefore(now);
    }

    @Override
    public void askQuest() {
        super.askQuest();
        System.out.println("Enter Alarm hh:mm time:");
        time = Main.askTime();
    }

    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || time.format(Main.TIME_FORMATTER).contains(str);
    }
}
