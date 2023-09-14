import java.util.HashMap;
import java.util.Map;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Map<Character, Integer> letterMap = new HashMap<>();

        char[] letters = phrase.chars()
                .filter(Character::isLetter)
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
                .toCharArray();

        for (Character ch : letters)
            letterMap.put(ch, 0);

        for (Character ch : letters) {
            int letterCount = letterMap.get(ch);
            letterMap.put(ch, letterCount + 1);
            int updatedCount = letterMap.get(ch);
            if (updatedCount > 1)
                return false;
        }

        return true;
    }

}
