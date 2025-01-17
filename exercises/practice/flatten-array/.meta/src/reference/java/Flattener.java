import java.util.ArrayList;
import java.util.List;

class Flattener {

    List<Object> flatten(List<?> list) {
        List<Object> flattenedList = new ArrayList<>();
        for (Object element: list) {
            if (element instanceof List<?> listAsElement) {
                flattenedList.addAll(flatten(listAsElement));
            } else if (element != null) {
                flattenedList.add(element);
            }
        }
        return flattenedList;
    }
}
