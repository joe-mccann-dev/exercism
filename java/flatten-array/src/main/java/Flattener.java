import java.util.ArrayList;
import java.util.List;

class Flattener {

    public <T> List<T> flatten(List<T> list) {
        List<T> result = new ArrayList<>();
        flatten(list, result);

        return result;
    }

    @SuppressWarnings("unchecked")
    private <T> void flatten(List<T> list, List<T> result) {
        for (T listItem : list) {
            if (listItem instanceof List)
                flatten((List<T>) listItem, result);
            else if (listItem != null)
                result.add(listItem);
        }
    }
}