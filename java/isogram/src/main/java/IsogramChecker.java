import java.util.HashMap;
import java.util.Map;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        // create an empty HashMap<Character, Integer> with char being the letter and
        // Integer being num times it occurs
        // convert phrase toLowerCase()
        // for each letter character of phrase put to hash map
        // iterate thru hash map, return false if a count is greater than 1

        Map<Character, Integer> letterMap = new HashMap<>();
        phrase = phrase.toLowerCase();

        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch))
                letterMap.put(ch, 0);        
        }

        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            int letterCount;
            if (Character.isLetter(ch)) {
                letterCount = letterMap.get(ch);
                letterMap.put(ch, letterCount + 1);
            }
        }

        for (Integer letterCount : letterMap.values()) {
            if (letterCount > 1)
                return false;
        }

        return true;

    }

}
