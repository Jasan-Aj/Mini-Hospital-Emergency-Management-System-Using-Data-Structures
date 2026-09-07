public class CareRecord {

    private int patientId;
    private String patientName;
    private String treatment;
    private String date;

    public CareRecord(int patientId, String patientName, String treatment, String date) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatment = treatment;
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void showRecord() {
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Patient Name : " + patientName);
        System.out.println("Treatment    : " + treatment);
        System.out.println("Date         : " + date);
    }
}