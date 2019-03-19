public class Record {
    private int recordId;
    private int parentId;

    public Record(int recordId, int parentId) {
        this.recordId = recordId;
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public int getRecordId() {
        return recordId;
    }
}
