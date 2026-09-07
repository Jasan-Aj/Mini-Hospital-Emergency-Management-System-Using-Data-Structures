public class LineCell {

    Patient data;
    LineCell next;

    public LineCell(Patient patient) {
        data = patient;
        next = null;
    }
}