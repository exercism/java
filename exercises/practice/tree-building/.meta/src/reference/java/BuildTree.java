import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class BuildTree {

    static TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {
        if (records.isEmpty()) {
            return null;
        }

        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashMap<Integer, TreeNode> nodesMap = new HashMap<>();
        records.sort(Comparator.comparing(Record::recordId));

        ArrayList<Integer> orderedRecordIds = new ArrayList<>();

        for (Record record : records) {
            orderedRecordIds.add(record.recordId());
        }

        for (Record record : records) {
            validateRecord(record);
            parentMap.put(record.recordId(), record.parentId());
            nodesMap.put(record.recordId(), new TreeNode(record.recordId()));
        }

        int rootId = 0;

        for (int i = 0; i < records.size(); i++) {
            if (i != orderedRecordIds.get(i)) {
                // Matches "non-continuous" or "no root node"
                throw new InvalidRecordsException("record id is invalid or out of order");
            }
            if (orderedRecordIds.get(i) != rootId) {
                int parentId = parentMap.get(i);
                nodesMap.get(parentId).getChildren().add(nodesMap.get(i));
            }
        }

        return nodesMap.get(rootId);
    }

    private static void validateRecord(Record record) throws InvalidRecordsException {
        if (record.recordId() == 0 && record.parentId() != 0) {
            throw new InvalidRecordsException("node parent_id should be smaller than its record_id");
        }

        if (record.recordId() == record.parentId() && record.recordId() != 0) {
            throw new InvalidRecordsException("record id is invalid or out of order");
        }

        if (record.parentId() > record.recordId()) {
            throw new InvalidRecordsException("record id is invalid or out of order");
        }
    }
}
