import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char letter) {
        List<String> result = new ArrayList<>();
        int distanceFromA = (int) letter - (int) 'A';
        char middleLetter = (char) (distanceFromA + (int) 'A');

        char oneBeforeMiddleLetter = (char) ((int) (middleLetter - 1));
        result.add(String.valueOf(" " + (oneBeforeMiddleLetter)) + " ");
        result.add(String.valueOf(middleLetter) + " " + String.valueOf(middleLetter));
        result.add(String.valueOf(" " + (oneBeforeMiddleLetter)) + " ");

        return result;
    }

}
