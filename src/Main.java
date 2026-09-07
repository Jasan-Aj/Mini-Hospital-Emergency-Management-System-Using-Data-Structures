import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static PatientTree records = new PatientTree();

    public static void main(String[] args) {
        boolean open = true;
        while (open) {
            System.out.println();
            System.out.println("=================================");
            System.out.println("      HOSPITAL RECORD SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Patient Records");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            switch (choose()) {
                case 1:
                    patientRecords();
                    break;
                case 2:
                    System.out.println("System closed. Goodbye!");
                    open = false;
                    break;
                default:
                    System.out.println("Wrong option. Pick 1 or 2.");
            }
        }
    }

    private static void patientRecords() {
        boolean stay = true;
        while (stay) {
            System.out.println();
            System.out.println("---------- PATIENT RECORDS ----------");
            System.out.println("1. Register a New Patient");
            System.out.println("2. Find a Patient");
            System.out.println("3. Delete a Patient");
            System.out.println("4. Show the Patients List");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            switch (choose()) {
                case 1:
                    registerNew();
                    break;
                case 2:
                    findOne();
                    break;
                case 3:
                    deleteOne();
                    break;
                case 4:
                    records.showAll();
                    break;
                case 5:
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong option.");
            }
        }
    }

    private static void registerNew() {
        System.out.print("Patient ID: ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.print("Patient Name: ");
        String name = scan.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scan.nextLine());
        System.out.print("Phone Number: ");
        String phone = scan.nextLine();
        System.out.print("Illness: ");
        String illness = scan.nextLine();

        records.addPatient(new Patient(id, name, age, phone, illness));
        System.out.println("Patient " + name + " has been registered.");
    }

    private static void findOne() {
        System.out.print("Patient ID to find: ");
        int id = Integer.parseInt(scan.nextLine());

        Patient found = records.findPatient(id);
        if (found == null) {
            System.out.println("No patient with ID " + id + ".");
            return;
        }
        System.out.println("Patient found.");
        found.showCard();
    }

    private static void deleteOne() {
        System.out.print("Patient ID to delete: ");
        int id = Integer.parseInt(scan.nextLine());

        Patient found = records.findPatient(id);
        if (found == null) {
            System.out.println("No patient with ID " + id + ".");
            return;
        }
        records.deletePatient(id);
        System.out.println("Patient " + found.getName() + " has been deleted.");
    }

    private static int choose() {
        while (true) {
            String line = scan.nextLine();
            if (line.matches("[0-9]+")) {
                return Integer.parseInt(line);
            }
            System.out.print("Please type a number: ");
        }
    }
}