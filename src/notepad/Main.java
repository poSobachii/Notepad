package notepad;

import java.util.Scanner;
import java.util.*;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static List<Record> records = new ArrayList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command or type 'help' to see list of available commands ");
            String cmd = scan.next();
            switch (cmd) {
                case "help": help(); break;
                case "crp": createP(); break;
                case "crn": createN(); break;
                case "list": list(); break;
                case "delete": delete(); break;
                case "find": find(); break;
                case "exit": return;
                default:
                    System.out.println("It's not a command");
            }
        }
    }


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


//    private static void list() {
//        for (int i = 0; i < records.size(); i++) {
//            System.out.println(records.get(i));
//        }
//    }


    private static void list() {
        for (Record p : records) {
            System.out.println(p);
        }
    }

    private static void help() {
        System.out.println("List of available commands: ");
        System.out.println("crp - to create new person ");
        System.out.println("crn - to create new note ");
        System.out.println("list - to see all records ");
        System.out.println("delete - to delete record ");
        System.out.println("exit - to exit program ");

    }


    private static void createP() {

        Scanner in = new Scanner(System.in);
        Person pers = new Person();

        System.out.println("Enter Name: ");
        String name = in.nextLine();
        pers.setName(name);

        System.out.println("Enter Surname: ");
        String surn = in.nextLine();
        pers.setSurname(surn);

        do {
            System.out.println("Enter phone number: ");
            String phon = in.nextLine();
            if (phon.length() <= 5) {
                System.out.println("number to small");
            } else {
                pers.setPhone(phon);
                break;
            }
        } while (true);

        System.out.println("Enter email: ");
        String ema = in.nextLine();
        pers.setEmail(ema);

        records.add(pers);

        System.out.println(pers);

    }

    private static void createN() {
        Note nt = new Note();
        Scanner scr = new Scanner(System.in);

        System.out.println("Enter desired note");
        String in = scr.nextLine();
        nt.setText(in);

        records.add(nt);

        System.out.println(nt);
    }

    private static void find() {
        Scanner scr = new Scanner(System.in);

        System.out.println("Find what ?");
        String input = scr.nextLine();
        for (Record r : records) {
//            if ( r instanceof Person)
            if (r.hasSubstring(input)){
                System.out.println(r);
            }

        }
    }

//    private static String askString() {
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

}