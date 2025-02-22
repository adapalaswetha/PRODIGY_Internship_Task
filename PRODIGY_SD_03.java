import java.util.ArrayList;
import java.util.Scanner;

public class PRODIGY_SD_03 {
    static class Contact {
        String name;
        String phoneNumber;
        String emailAddress;

        public Contact(String name, String phoneNumber, String emailAddress){
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        public void displayContacts(){
            System.out.println("Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress);
        }
    }

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // add the contact
    public void addContacts() {
        System.out.print("Enter the Name: ");
        String name = input.nextLine();

        System.out.print("Enter the Phone Number: ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter the Email Address: ");
        String emailAddress = input.nextLine();

        contacts.add(new Contact(name, phoneNumber, emailAddress));
        System.out.println("Contact added Successfully!\n");
    }

    // display the contacts
    public void displayContacts() {
        if(contacts.isEmpty()){
            System.out.println("No Contacts Available.\n");
            return;
        }
        System.out.print("Contact List: ");
        for(Contact contact : contacts){
            contact.displayContacts();
        }
        System.out.println();
    }

    // update the contacts
    public void updateContacts() {
        System.out.print("Enter the index of the contact you want to edit: ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 0 && index < contacts.size()) {
            System.out.println("Editing Contact:");

            System.out.print("Enter new Name: ");
            String newName = input.nextLine();

            System.out.print("Enter new Phone Number: ");
            String newPhoneNumber = input.nextLine();

            System.out.print("Enter new Email Address: ");
            String newEmailAddress = input.next();

            Contact updatedContact = new Contact(newName, newPhoneNumber, newEmailAddress);
            contacts.set(index, updatedContact);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }

        // delete the contact
    }

    // delete the contact
    public void deleteContacts(){
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.print("Enter the index of the contact you want to delete: ");
            int index = input.nextInt();

            if (index >= 0 && index < contacts.size()) {
                System.out.println("Deleting Contact:");
                contacts.remove(index);
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("Contact Management System");
            System.out.println("1. Add New Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addContacts();
                case 2 -> displayContacts();
                case 3 -> updateContacts();
                case 4 -> deleteContacts();
                case 5 -> {
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please enter a valid option.\n");
            }
        }
    }

    public static void main(String[] args) {
        PRODIGY_SD_03 contact = new PRODIGY_SD_03();
        contact.menu();
    }
}
