import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PangramChecker {

    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public boolean isPangram(String input) {
        Map<Character, Integer> inputLetterMap = input.toLowerCase().chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLetter)
                .collect(Collectors.toMap(
                        ch -> ch,
                        ch -> 1,
                        Integer::sum));

        var alphabetChars = ALPHABET.chars().mapToObj(ch -> (char) ch);

        return alphabetChars.allMatch(ch -> {
            int inputLetterCount = Optional.ofNullable(inputLetterMap.get(ch)).orElse(0);
            return inputLetterCount > 0;
        });
    }
}