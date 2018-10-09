package notepad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Reminder extends Note{
    private LocalDate date;
    private LocalTime time;



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reminder{ #" + getId() +
                ", text='" + getText() + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public void askQuest() {
        Scanner in = new Scanner(System.in);
        super.askQuest();
        System.out.println("Enter reminder date DD/MM/YYYY :");
        date = Main.askDate();
        System.out.println("Enter reminder hh:mm time:");
        time = Main.askTime();
    }

    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || date.format(Main.DATE_FORMATTER).contains(str)
                || time.format(Main.TIME_FORMATTER).contains(str);
    }
}
