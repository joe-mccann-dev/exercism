import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Anagram {

    private String wordToMatch;
    private Map<Character, Integer> wordToMatchMap;

    public Anagram(String word) {
        setWordToMatch(word.toLowerCase());
        setWordToMatchMap();
    }

    public List<String> match(List<String> candidates) {
        return candidates.stream().filter(candidate -> isAnagram(candidate)).toList();
    }

    private void setWordToMatch(String word) {
        this.wordToMatch = word;
    }

    private void setWordToMatchMap() {
        this.wordToMatchMap = getWordToMatch().chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(
                        ch -> ch,
                        ch -> 1,
                        Integer::sum));
    }

    private boolean isAnagram(String candidate) {
        if (wordsAreDifferentLengthOrIdentical(candidate))
            return false;

        var wordToMatchChars = getWordToMatch().chars().mapToObj(ch -> (char) ch);

        return wordToMatchChars.allMatch(ch -> {
            int letterCount = getWordToMatchMap().get(ch);
            int candidateLetterCount = Optional.ofNullable(getCandidateMap(candidate).get(ch)).orElse(0);
            return letterCount == candidateLetterCount;
        });
    }

    private boolean wordsAreDifferentLengthOrIdentical(String candidate) {
        return getWordToMatch().length() != candidate.length() ||
                getWordToMatch().equalsIgnoreCase(candidate);
    }

    private String getWordToMatch() {
        return this.wordToMatch;
    }

    private Map<Character, Integer> getWordToMatchMap() {
        return this.wordToMatchMap;
    }

    private Map<Character, Integer> getCandidateMap(String candidate) {
        return candidate.toLowerCase().chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(
                        ch -> ch,
                        ch -> 1,
                        Integer::sum));
    }
}