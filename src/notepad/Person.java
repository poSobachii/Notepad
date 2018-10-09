package notepad;

import java.util.Scanner;

public class Person extends Record {

    private String name;
    private String surname;
    private String phone;
    private String email;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Person{ #" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return name.contains(str)
                || surname.contains(str)
                || phone.contains(str)
                || email.contains(str);
    }

    @Override
    public void askQuest() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Name: ");
        name = in.nextLine();

        System.out.println("Enter Surname: ");
        surname = in.nextLine();

        do {
            System.out.println("Enter phone number: ");
            String phon = in.nextLine();
            if (phon.length() <= 5) {
                System.out.println("number to small");
            } else {
                phone = phon;
                break;
            }
        } while (true);

        System.out.println("Enter email: ");
        email = in.nextLine();

    }
}
