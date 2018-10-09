package notepad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;


public class Main {
    public final static String DATE_FORMAT = "dd/MM/yyyy";
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public final static String TIME_FORMAT = "HH:mm";
    public final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    static Scanner scan = new Scanner(System.in);
    static List<Record> records = new ArrayList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command or type 'help' to see list of available commands ");
            String cmd = scan.next();
            switch (cmd) {
                case "help":
                    help();
                    break;
                case "crp":
                    createP();
                    break;
                case "crn":
                    createN();
                    break;
                case "crr":
                    createR();
                    break;
                case "list":
                    list();
                    break;
                case "delete":
                    delete();
                    break;
                case "find":
                    find();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("It's not a command");
            }
        }
    }

    private static void help() {
        System.out.println("List of available commands: ");
        System.out.println("crp - to create new person ");
        System.out.println("crn - to create new note ");
        System.out.println("crr - to create new reminder ");
        System.out.println("list - to see all records ");
        System.out.println("delete - to delete record ");
        System.out.println("exit - to exit program ");

    }

    private static void addRec(Record recs) {
        recs.askQuest();
        records.add(recs);
        System.out.println(recs);
    }

    private static void createP() {
        Person pers = new Person();
        addRec(pers);
    }

    private static void createN() {
        Note nt = new Note();
        addRec(nt);
    }

    private static void createR() {
        Reminder alarm = new Reminder();
        addRec(alarm);
    }

    private static void list() {
        for (Record p : records) {
            System.out.println(p);
        }
    }

    //    private static void list() {
//        for (int i = 0; i < records.size(); i++) {
//            System.out.println(records.get(i));
//        }
//    }

    private static void delete() {
        System.out.println("Type id number for delete");
        int del = scan.nextInt();
        for (Record a : records) {
            if (a.getId() == del) {
                records.remove(a);
                break;
            }
        }
        System.out.println("Selected person have been removed !");
        for (Record p : records) {
            System.out.println(p);
        }
    }

    //    private static void delete() {
//        System.out.println("#id ?");
//        int id = scan.nextInt();
//        for (int i = 0; i < records.size(); i++) {
//            Record p = records.get(i);
//            if (id == p.getId()) {
//                records.remove(i);
//                break;
//            }
//        }
//        for (Record p : records){
//            System.out.println(p);
//        }
//    }

    private static void find() {
        Scanner scr = new Scanner(System.in);

        System.out.println("Find what ?");
        String input = scr.nextLine();
        for (Record r : records) {
//            if ( r instanceof Person)
            if (r.hasSubstring(input)) {
                System.out.println(r);
            }

        }
    }

        public static LocalDate askDate () {
            Scanner scr = new Scanner(System.in);
            String in = scr.nextLine();
            LocalDate date = LocalDate.parse(in, DATE_FORMATTER);
            return date;
        }

        public static LocalTime askTime () {
            Scanner scr = new Scanner(System.in);
            String in = scr.nextLine();
            LocalTime time = LocalTime.parse(in, TIME_FORMATTER);
            return time;
    }
}



// -------------------------------------------------------------------------------------------------------------------

//    // More advanced phone validation Ļ(but still should be treated as an example)
//    public static String askPhone() {
//        while (true) {
//            String phone = askString();
//            // checking if there any characters expect digits, spaces, pluses and dashes
//            if (phone.chars().anyMatch(c -> !Character.isDigit(c) && c != ' ' && c != '+' && c != '-')) {
//                System.out.println("Only digits, spaces, plus and dash are allowed!");
//                continue;
//            }
//
//            // checking how many digits in the entered number (excluding spaces and other non-digits)
//            if (phone.chars().filter(Character::isDigit).count() < 5) {
//                System.out.println("At least 5 digits in phone number");
//                continue;
//            }
//
//            // validation passed
//            return phone;
//        }
//    }




//    public static String askString() {
//        var result = new ArrayList<String>();
//        var word = scan.next();
//        if (word.startsWith("\"")){
//            do {
//                result.add(word);
//                if (word.endsWith("\"")){
//                    String str = String.join(" ", result);
//                    return str.substring(1, str.length()-1);
//                }
//                word = scan.next();
//            } while (true);
//        } else {
//            return word;
//        }
//
//
//    }

