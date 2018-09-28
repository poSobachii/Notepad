package notepad;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static List<Person> persons = new ArrayList();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command or type 'help' to see list of available commands ");
            String cmd = scan.next();
            switch (cmd) {
                case "help":
                    help();
                    break;
                case "create":
                    create();
                    break;
                case "list":
                    list();
                    break;
                case "exit":
                    return;
                case "delete":
                    delete();
                    break;
                default:
                    System.out.println("It's not a command");
            }
        }
    }

    private static void delete() {
        System.out.println("Type id number for delete");
        Integer del = scan.nextInt();
        for (Person a : persons) {
            if (a.getId() == del) {
                persons.remove(a);
                break;
            }
        }
        for (Person p : persons) {
            System.out.println(p);
        }
    }

//        for (Person p : persons){
//            Integer ind = p.getId();
//            if (ind == del) {
//                persons.remove(ind);
//                break;
//            }
//
//        }


    private static void list() {
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }

    private static void help() {
        System.out.println("List of available commands: "
                + '\n' + "create - to create new person"
                + '\n' + "list - to see all persons"
                + '\n' + "delete - to delete person"
                + '\n' + "exit - to exit program");
    }

//    private static void list() {
//        for (Person p : persons) {
//            System.out.println(p);
//        }
//    }


    private static void create() {

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

        persons.add(pers);

        System.out.println(pers);

    }

}
