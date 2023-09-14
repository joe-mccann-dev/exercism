import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Anagram {

    private String wordToMatch;
    private Map<Character, Integer> wordToMatchMap;

    public Anagram(String word) {
        setWordToMatch(word);
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

        if (getWordToMatch().equals(candidate.toLowerCase()))
            return false;

        Map<Character, Integer> candidateLetterMap = getCandidateLetterCount(candidate);

        for (Character ch : getWordToMatch().toCharArray()) {
            int letterCount = getWordToMatchMap().get(ch);
            int candidateLetterCount = candidateLetterMap.get(ch) != null ? candidateLetterMap.get(ch) : 0;
            if (letterCount != candidateLetterCount)
                return false;
        }

        return true;
    }

    private Map<Character, Integer> getCandidateLetterCount(String candidate) {
        Map<Character, Integer> currentWordMap = new HashMap<>();
        char[] candidateChars = candidate.toLowerCase().toCharArray();
        for (Character ch : candidateChars)
            currentWordMap.put(ch, 0);

        for (Character ch : candidateChars) {
            int charCount = currentWordMap.get(ch);
            currentWordMap.put(ch, charCount + 1);
        }

        return currentWordMap;

    }

    private String getWordToMatch() {
        return this.wordToMatch.toLowerCase();
    }

    private void setWordToMatch(String word) {
        this.wordToMatch = word;
    }

    private Map<Character, Integer> getWordToMatchMap() {
        return this.wordToMatchMap;
    }

    private void setWordToMatchMap() {
        this.wordToMatchMap = new HashMap<>();

        char[] wordChars = getWordToMatch().toLowerCase().toCharArray();

        for (Character ch : wordChars)
            this.wordToMatchMap.put(ch, 0);

        for (Character ch : wordChars) {
            int charCount = this.wordToMatchMap.get(ch);
            this.wordToMatchMap.put(ch, charCount + 1);
        }
    }

}