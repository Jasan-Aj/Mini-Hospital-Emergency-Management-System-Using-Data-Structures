public class CareLog {

    private HistoryCell top;

    public CareLog() {
        top = null;
    }

    public void saveRecord(CareRecord record) {
        HistoryCell newCell = new HistoryCell(record);
        newCell.below = top;
        top = newCell;
        System.out.println("Record kept for " + record.getPatientName() + ".");
    }

    public CareRecord takeLatest() {
        if (top == null) {
            System.out.println("No records to undo.");
            return null;
        }
        CareRecord latest = top.data;
        top = top.below;
        System.out.println("Latest record for " + latest.getPatientName() + " removed.");
        return latest;
    }

    public void showHistory() {
        if (top == null) {
            System.out.println("No treatment history yet.");
            return;
        }
        System.out.println("---------- TREATMENT HISTORY ----------");
        HistoryCell current = top;
        int number = 1;
        while (current != null) {
            System.out.println("Entry " + number + ":");
            current.data.showRecord();
            System.out.println("-------------------------------------");
            current = current.below;
            number++;
        }
    }
}