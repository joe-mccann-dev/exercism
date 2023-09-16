import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    final static int ASCII_UPPERCASE_A = 65;

    List<String> printToList(char letter) {
        List<String> result = new ArrayList<>();
        int asciiLetter = (int) letter;
        int distanceFromAToLetter = Math.abs((ASCII_UPPERCASE_A - asciiLetter));
        int startToMiddle = (distanceFromAToLetter);
        int diamondHeight = (startToMiddle * 2) + 1;

        String centerPaddedA = centerPad(distanceFromAToLetter, "A");



        result.add(centerPaddedA);


        return result;
    }

    private String leftPad(int distanceFromAToLetter, String letter) {
        int leftWidth = distanceFromAToLetter + 1;
        String leftPadded = String.format("%" + (leftWidth) + "s", "A");
        
        return leftPadded;
    }

    private String centerPad(int distanceFromAToLetter, String letter) {
        int leftWidth = distanceFromAToLetter + 1;
        int totalWidth = (leftWidth * 2) - 1;

        String leftPadded = leftPad(distanceFromAToLetter, letter);
        String centerPadded = String.format("%" + (-totalWidth) + "s", leftPadded);

        return centerPadded;
    }

}
