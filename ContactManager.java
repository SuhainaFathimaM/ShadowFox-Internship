import java.util.*;

public class ContactManager {

    static HashMap<String, Contact> contacts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (true) {
            System.out.println("\n Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice:");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    addContact(scanner);
                    break;

                case 2:
                    viewContacts(scanner);
                    break;

                case 3:
                    updateContact(scanner);
                    break;
                
                case 4:
                    deleteContact(scanner);
                    break;

                case 5:
                    System.out.println("Exiting!!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");

            }


            
        }

    }

    static void addContact(Scanner scanner)
    {
        System.out.print("Enter Contact Name:");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number:");
        String phone = scanner.nextLine();

        System.out.print("Enter Email Address:");
        String email = scanner.nextLine();

        contacts.put(name,new Contact(name, phone, email));
        System.out.println("Contact Added Successfully");

    }

    static void viewContacts(Scanner scanner)
    {
        if(contacts.isEmpty())
        {
            System.out.println("No Contacts Available");
            return;
        }
        System.out.println("\n Contacts:");

        for (Contact contact: contacts.values())
        {
            System.out.println("Name: " + contact.name);
            System.out.println("Phone: " + contact.phone);
            System.out.println("Email: " + contact.email);
            System.out.println("--------------------");
        }
    }

    static void updateContact(Scanner scanner)
    {
        System.out.println("Enter the name of the contact to update: ");
        String name = scanner.nextLine();

        if(!contacts.containsKey(name))
        {
            System.out.println("Contact not found.");
            return;
        }

        Contact contact = contacts.get(name);

        System.out.println("Enter new phone number (Leave blank to keep the current):");
        String newPhone = scanner.nextLine();
        if(!newPhone.isEmpty())
        {
            contact.phone = newPhone;
        }
        System.out.println("Enter new Email Address (Leave blank to keep the current):");
        String newEmail = scanner.nextLine();
        if(!newEmail.isEmpty())
        {
            contact.email = newEmail;
        }

        System.out.println("Contact Updated Successfully");

    }

    static void deleteContact(Scanner scanner)
    {
        System.out.println("Enter name of the contact to delete");
        String name = scanner.nextLine();

        if(!contacts.containsKey(name))
        {
            System.out.println("Contact not found.");
            return;
        }
        contacts.remove(name);
        System.out.println("Contact Deleted Successfully");

    }
}

class Contact{
    String name, phone, email;

    public Contact(String name, String phone, String email)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

