class Record {
    private int recordId;
    private int parentId;

    public Record(int recordId, int parentId) {
        this.recordId = recordId;
        this.parentId = parentId;
    }

    int getParentId() {
        return parentId;
    }

    int getRecordId() {
        return recordId;
    }
}
