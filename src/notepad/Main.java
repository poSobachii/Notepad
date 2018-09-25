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
            System.out.println("Enter command:");
            String cmd = scan.next();
            switch (cmd) {
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
        for (Person p : persons){
            Integer ind = p.getId();
            if (ind == del) {
                persons.remove(ind);
                break;
            }

        }
                for (Person p : persons) {
            System.out.println(p);
        }
    }

    private static void list() {
        for (int i = 0; i < persons.size() ; i++) {
            System.out.println(persons.get(i));
        }
    }

//    private static void list() {
//        for (Person p : persons) {
//            System.out.println(p);
//        }
//    }


    private static void create() {
        System.out.println("Enter Name: ");
        String name = scan.next();
        System.out.println("Enter Surname: ");
        String surn = scan.next();
        System.out.println("Enter phone number: ");
        String phon = scan.next();

        Person pers = new Person();

        pers.setName(name);
        pers.setSurname(surn);
        pers.setPhone(phon);
        persons.add(pers);

        System.out.println(pers);

    }

}
