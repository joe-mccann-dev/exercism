import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class Anagram {

    private String wordToMatch;
    private Map<Character, Integer> wordToMatchMap;

    public Anagram(String word) {
        setWordToMatch(word.toLowerCase());
        setWordToMatchMap();
    }

    public List<String> match(List<String> candidates) {
        List<String> result = new ArrayList<>();
        for (String candidate : candidates) {
            if (isAnagram(candidate))
                result.add(candidate);
        }

        return result;
    }

    private boolean isAnagram(String candidate) {
        if (getWordToMatch().length() != candidate.length())
            return false;

        if (getWordToMatch().equalsIgnoreCase(candidate))
            return false;

        Map<Character, Integer> candidateLetterMap = getCandidateLetterMap(candidate);

        for (Character ch : getWordToMatch().toCharArray()) {
            int letterCount = getWordToMatchMap().get(ch);
            int candidateLetterCount = Optional.ofNullable(candidateLetterMap.get(ch)).orElse(0);
            if (letterCount != candidateLetterCount)
                return false;
        }

        return true;
    }

    private Map<Character, Integer> getCandidateLetterMap(String candidate) {
        Map<Character, Integer> currentWordMap = new HashMap<>();
        char[] candidateChars = candidate.toLowerCase().toCharArray();

        for (Character ch : candidateChars) {
            currentWordMap.computeIfAbsent(ch, k -> 0);
            currentWordMap.put(ch, currentWordMap.get(ch) + 1);
        }

        return currentWordMap;
    }

    private String getWordToMatch() {
        return this.wordToMatch;
    }

    private void setWordToMatch(String word) {
        this.wordToMatch = word;
    }

    private Map<Character, Integer> getWordToMatchMap() {
        return this.wordToMatchMap;
    }

    private void setWordToMatchMap() {
        this.wordToMatchMap = new HashMap<>();

        char[] wordChars = getWordToMatch().toCharArray();

        for (Character ch : wordChars) {
            this.wordToMatchMap.computeIfAbsent(ch, k -> 0);
            this.wordToMatchMap.put(ch, getWordToMatchMap().get(ch) + 1);
        }
    }
}