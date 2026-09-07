public class VisitLog {

    private VisitCell head;

    public VisitLog() {
        head = null;
    }

    public void addVisit(ClinicVisit visit) {
        VisitCell newCell = new VisitCell(visit);
        if (head == null) {
            head = newCell;
        } else {
            VisitCell current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newCell;
        }
        System.out.println("Visit " + visit.getVisitId() + " recorded.");
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visits to delete.");
            return;
        }
        if (head.data.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit " + visitId + " deleted.");
            return;
        }
        VisitCell current = head;
        while (current.next != null) {
            if (current.next.data.getVisitId() == visitId) {
                current.next = current.next.next;
                System.out.println("Visit " + visitId + " deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Visit " + visitId + " not found.");
    }

    public ClinicVisit searchVisit(int visitId) {
        VisitCell current = head;
        while (current != null) {
            if (current.data.getVisitId() == visitId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void showVisits() {
        if (head == null) {
            System.out.println("  No visits recorded for this patient.");
            return;
        }
        VisitCell current = head;
        while (current != null) {
            current.data.showVisit();
            System.out.println("................................................");
            current = current.next;
        }
    }
}