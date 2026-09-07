public class WaitingLine {

    private LineCell front;
    private LineCell back;

    public WaitingLine() {
        front = null;
        back = null;
    }

    public void joinLine(Patient patient) {
        LineCell newCell = new LineCell(patient);
        if (back == null) {
            front = newCell;
            back = newCell;
        } else {
            back.next = newCell;
            back = newCell;
        }
    }

    public Patient treatNext() {
        if (front == null) {
            System.out.println("Nobody is waiting right now.");
            return null;
        }
        Patient first = front.data;
        front = front.next;
        if (front == null) {
            back = null;
        }
        return first;
    }

    public void showLine() {
        if (front == null) {
            System.out.println("The waiting room is empty.");
            return;
        }
        System.out.println("---------- PATIENTS WAITING ----------");
        LineCell current = front;
        int spot = 1;
        while (current != null) {
            System.out.println("Spot " + spot + ":");
            current.data.showCard();
            System.out.println("------------------------------------");
            current = current.next;
            spot++;
        }
    }
}