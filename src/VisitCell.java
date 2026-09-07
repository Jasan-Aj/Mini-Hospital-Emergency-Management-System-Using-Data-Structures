public class VisitCell {

    ClinicVisit data;
    VisitCell next;

    public VisitCell(ClinicVisit visit) {
        data = visit;
        next = null;
    }
}