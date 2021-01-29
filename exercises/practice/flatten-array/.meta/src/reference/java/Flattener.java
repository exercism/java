import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Flattener {

    List flatten(final List nestedList) {
        if (nestedList.isEmpty()) {
            return new ArrayList<>();
        } else {
            final List result = new ArrayList();

            final Object head = nestedList.get(0);
            final List tail = nestedList.subList(1, nestedList.size());

            if (head instanceof List) {
                result.addAll(flatten((List) head));
            } else {
                result.add(head);
            }

            result.addAll(flatten(tail));
            result.removeAll(Collections.singleton(null));
            return result;
        }
    }

}
