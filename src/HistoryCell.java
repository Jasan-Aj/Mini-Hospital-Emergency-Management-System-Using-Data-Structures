public class HistoryCell {

    CareRecord data;
    HistoryCell below;

    public HistoryCell(CareRecord record) {
        data = record;
        below = null;
    }
}