import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static PatientTree records = new PatientTree();
    private static WaitingLine line = new WaitingLine();

    public static void main(String[] args) {
        boolean open = true;
        while (open) {
            System.out.println();
            System.out.println("===================================");
            System.out.println("   HOSPITAL EMERGENCY MANAGEMENT");
            System.out.println("===================================");
            System.out.println("1. Patient Records");
            System.out.println("2. Emergency Waiting Room");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            switch (choose()) {
                case 1:
                    patientRecords();
                    break;
                case 2:
                    emergencyRoom();
                    break;
                case 3:
                    System.out.println("System closed. Goodbye!");
                    open = false;
                    break;
                default:
                    System.out.println("Wrong option. Pick 1, 2 or 3.");
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

    private static void emergencyRoom() {
        boolean stay = true;
        while (stay) {
            System.out.println();
            System.out.println("-------- EMERGENCY WAITING ROOM --------");
            System.out.println("1. Add a Patient to the Line");
            System.out.println("2. Treat the Next Patient");
            System.out.println("3. Show Who Is Waiting");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            switch (choose()) {
                case 1:
                    addToLine();
                    break;
                case 2:
                    treatNextOne();
                    break;
                case 3:
                    line.showLine();
                    break;
                case 4:
                    stay = false;
                    break;
                default:
                    System.out.println("Wrong option.");
            }
        }
    }

    private static void addToLine() {
        System.out.print("Patient ID: ");
        int id = Integer.parseInt(scan.nextLine());

        Patient found = records.findPatient(id);
        if (found == null) {
            System.out.println("Patient not found. Register them first.");
            return;
        }
        line.joinLine(found);
        System.out.println(found.getName() + " has joined the line.");
    }

    private static void treatNextOne() {
        Patient next = line.treatNext();
        if (next != null) {
            System.out.println(next.getName() + " is now being treated.");
        }
    }

    private static int choose() {
        while (true) {
            String option = scan.nextLine();
            if (option.matches("[0-9]+")) {
                return Integer.parseInt(option);
            }
            System.out.print("Please type a number: ");
        }
    }
}