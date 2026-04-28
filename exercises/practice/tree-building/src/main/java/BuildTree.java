import java.util.ArrayList;
import java.util.Comparator;

class BuildTree {

    static TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {
        records.sort(Comparator.comparing(Record::recordId));
        ArrayList<Integer> orderedRecordIds = new ArrayList<>();

        for (Record record : records) {
            orderedRecordIds.add(record.recordId());
        }

        if (records.size() > 0) {
            if (orderedRecordIds.get(orderedRecordIds.size() - 1) != orderedRecordIds.size() - 1) {
                // Matches non-continuous records or missing items in the sequence
                throw new InvalidRecordsException("record id is invalid or out of order");
            }
            if (orderedRecordIds.get(0) != 0) {
                // Matches cases where the root (ID 0) is missing
                throw new InvalidRecordsException("record id is invalid or out of order");
            }
        }

        ArrayList<TreeNode> treeNodes = new ArrayList<>();

        for (int i = 0; i < orderedRecordIds.size(); i++) {
            for (Record record : records) {
                if (orderedRecordIds.get(i) == record.recordId()) {
                    if (record.recordId() == 0 && record.parentId() != 0) {
                        // Specifically matches "root node has parent"
                        throw new InvalidRecordsException("node parent_id should be smaller than its record_id");
                    }
                    if (record.recordId() < record.parentId()) {
                        // Matches "higher id parent of lower id"
                        throw new InvalidRecordsException("record id is invalid or out of order");
                    }
                    if (record.recordId() == record.parentId() && record.recordId() != 0) {
                        // Matches "cycle directly"
                        throw new InvalidRecordsException("record id is invalid or out of order");
                    }
                    treeNodes.add(new TreeNode(record.recordId()));
                }
            }
        }

        for (int i = 0; i < orderedRecordIds.size(); i++) {
            TreeNode parent;
            for (TreeNode n : treeNodes) {
                if (i == n.getNodeId()) {
                    parent = n;
                    for (Record record : records) {
                        if (record.parentId() == i) {
                            for (TreeNode node : treeNodes) {
                                if (node.getNodeId() == 0) {
                                    continue;
                                }
                                if (record.recordId() == node.getNodeId()) {
                                    parent.getChildren().add(node);
                                }
                            }
                        }
                    }
                    break;
                }
            }

        }

        if (treeNodes.size() > 0) {
            return treeNodes.get(0);
        }

        return null;
    }

}