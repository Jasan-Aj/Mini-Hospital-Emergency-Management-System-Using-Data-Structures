public class ClinicVisit {

    private int visitId;
    private String visitDate;
    private String doctorName;
    private String diagnosis;
    private String medicine;

    public ClinicVisit(int visitId, String visitDate, String doctorName, String diagnosis, String medicine) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.medicine = medicine;
    }

    public int getVisitId() {
        return visitId;
    }

    public void showVisit() {
        System.out.println("Visit No   : " + visitId);
        System.out.println("Visit Date : " + visitDate);
        System.out.println("Doctor      : " + doctorName);
        System.out.println("Diagnosis  : " + diagnosis);
        System.out.println("Medicine   : " + medicine);
    }
}