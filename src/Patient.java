public class Patient {

    private int id;
    private String name;
    private int age;
    private String phone;
    private String illness;

    public Patient(int id, String name, int age, String phone, String illness) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.illness = illness;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void showCard() {
        System.out.println("Patient ID   : " + id);
        System.out.println("Patient Name : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Phone Number : " + phone);
        System.out.println("Illness      : " + illness);
    }
}