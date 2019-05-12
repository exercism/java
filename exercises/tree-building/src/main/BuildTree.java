import java.util.ArrayList;
import java.util.Comparator;

class BuildTree {

    TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {
        records.sort(Comparator.comparing(Record::getRecordId));
        ArrayList<Integer> orderedRecordIds = new ArrayList<>();

        for (Record record : records) {
            orderedRecordIds.add(record.getRecordId());
        }

        if (records.size() > 0) {
            if (orderedRecordIds.get(orderedRecordIds.size() - 1) != orderedRecordIds.size() - 1) {
                throw new InvalidRecordsException("Invalid Records");
            }
            if (orderedRecordIds.get(0) != 0) {
                throw new InvalidRecordsException("Invalid Records");
            }
        }

        ArrayList<TreeNode> treeNodes = new ArrayList<>();

        for (int i = 0; i < orderedRecordIds.size(); i++) {
            for (Record record : records) {
                if (orderedRecordIds.get(i) == record.getRecordId()) {
                    if (record.getRecordId() == 0 && record.getParentId() != 0) {
                        throw new InvalidRecordsException("Invalid Records");
                    }
                    if (record.getRecordId() < record.getParentId()) {
                        throw new InvalidRecordsException("Invalid Records");
                    }
                    if (record.getRecordId() == record.getParentId() && record.getRecordId() != 0) {
                        throw new InvalidRecordsException("Invalid Records");
                    }
                    treeNodes.add(new TreeNode(record.getRecordId()));
                }
            }
        }

        for (int i = 0; i < orderedRecordIds.size(); i++) {
            TreeNode parent;
            for (TreeNode n: treeNodes) {
                if (i == n.getNodeId()) {
                    parent = n;
                    for (Record record : records) {
                        if (record.getParentId() == i) {
                            for (TreeNode node : treeNodes) {
                                if (node.getNodeId() == 0) {
                                    continue;
                                }
                                if (record.getRecordId() == node.getNodeId()) {
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
