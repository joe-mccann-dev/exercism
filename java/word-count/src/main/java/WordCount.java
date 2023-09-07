import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        HashMap<String, Integer> result = new HashMap<>();
        List<String> words = Arrays.asList(input.split("[\\s\t\n,./;:`!@#$%^&*]+"))
                .stream()
                .map(word -> word.replaceAll("^'|'$", "").toLowerCase())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());
        
        for (String word : words)
            result.put(word, 0);

        for (String word : words) {
            int currentWordCount = result.get(word);
            result.put(word, ++currentWordCount);
        }

        return result;
    }
}
