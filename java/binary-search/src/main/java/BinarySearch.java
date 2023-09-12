import java.util.ArrayList;
import java.util.List;

class BinarySearch {

    List<Integer> sortedList = new ArrayList<>();

    BinarySearch(List<Integer> items) {
        this.sortedList = items;
    }

    int indexOf(int item) throws ValueNotFoundException {
        int mid = 0;
        int low = 0;
        int high = sortedList.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            int potentialMatch = sortedList.get(mid);
            if (potentialMatch > item) // item is in left half
                high = mid - 1;
            else if (potentialMatch < item) // item is in right half
                low = mid + 1;
            else
                return mid; // item is found
        }

        throw new ValueNotFoundException("Value not in array");
    }
}
