package notepad;

import java.util.Scanner;

public class Note extends Record {


    private String text;

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    @Override
    public String toString() {
        return "Note { #" + getId() + " text='"+ text + "'}";
    }

    @Override
    public boolean hasSubstring(String str) {
        return text.contains(str);
    }

    @Override
    public void askQuest() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter Text:");
        text = scr.nextLine();
    }
}
