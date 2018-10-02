package notepad;

public class Note extends Record {

    private String text;

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    @Override
    public String toString() {
        return "Note { #" + getId() + " - "+ text + " }";
    }

    @Override
    public boolean hasSubstring(String str) {
        return text.contains(str);
    }
}
