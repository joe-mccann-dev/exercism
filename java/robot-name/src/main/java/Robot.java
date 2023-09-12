import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

class Robot {

    private final static int PREFIX_LENGTH = 2;
    private final static int ASCII_UPPERCASE_A = 65;
    private final static int ASCII_UPPERCASE_Z = 90;
    private final static int LOWER_BOUND = 100;
    private final static int UPPER_BOUND = 999;

    private String name;
    private final static Set<String> TAKEN_NAMES = new HashSet<>();

    public Robot() {
        setName();
        TAKEN_NAMES.add(getName());
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        TAKEN_NAMES.remove(getName());
        setName();
    }

    private void setName() {
        StringBuilder robotName = new StringBuilder();
        boolean nameIsTaken = TAKEN_NAMES.contains(robotName.toString());

        while (nameIsTaken) {
            robotName = new StringBuilder();
            String prefix = getLetterPrefix(PREFIX_LENGTH);
            String randomNumber = String.valueOf(getRandomNumber(LOWER_BOUND, UPPER_BOUND));
            robotName.append(prefix);
            robotName.append(randomNumber);
            nameIsTaken = TAKEN_NAMES.contains(robotName.toString());
        }

        this.name = robotName.toString();

    }

    private String getLetterPrefix(int prefixLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < prefixLength; i++)
            result.appendCodePoint(getRandomNumber(ASCII_UPPERCASE_A, ASCII_UPPERCASE_Z));

        return result.toString();
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().ints(min, max).findAny().orElse(-1);
    }
}