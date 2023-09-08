import java.util.ArrayList;
import java.util.List;

class Flattener {

    public <T> List<T> flatten(List<T> list) {
        List<T> result = new ArrayList<>();
        flatten(list, result);

        return result;
    }

    private <T> List<T> flatten(List<T> list, List<T> result) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof List) {
                List<T> sublist = (List<T>) list.get(i);
                flatten(sublist, result);
            } else if (list.get(i) != null) {
                result.add(list.get(i));
            }

        }

        return result;
    }

}