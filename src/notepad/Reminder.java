package notepad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reminder extends Alarm implements Expired{
    private LocalDate date;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "Reminder{ #" + getId() +
                ", text='" + getText() + '\'' +
                ", date='" + date + '\'' +
                ", time='" + getTime() + '\'' +
                '}';
    }

    @Override
    public void askQuest() {
        super.askQuest();
        System.out.println("Enter Reminder date DD/MM/YYYY :");
        date = Main.askDate();
    }

    @Override
    public boolean isExpired() {
        LocalTime time = getTime();
        LocalDateTime dt = LocalDateTime.of(date, time);
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(dt);
    }

    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || date.format(Main.DATE_FORMATTER).contains(str);
    }
}
