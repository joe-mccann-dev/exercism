import java.util.ArrayList;
import java.util.List;

class Flattener {

    // calls private overloaded method
    // enables modifying result thru second parameter
    // private flatten method then calls itself recursively
    // when a list is encountered
    public <T> List<T> flatten(List<T> list) {
        List<T> result = new ArrayList<>();
        flatten(list, result);

        return result;
    }

    // only need to worry about List<T>
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