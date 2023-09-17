class TwelveDays {

    String verse(int verseNumber) {
        StringBuilder result = new StringBuilder();
        String intro = verseIntro(verseNumber);
        result.append(intro);

        int penUltimateVerse = 2;
        for (int i = verseNumber; i >= 1; i--) {
            if (i == penUltimateVerse) {
                result.append(verseFragment(penUltimateVerse) + " and ");
            } else if (i > 1) {
                result.append(verseFragment(i) + " ");
            } else {
                result.append(verseFragment(i));
            }
        }

        return result.toString();

    }

    String verses(int startVerse, int endVerse) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    String sing() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    private String verseFragment(int verseNumber) {

        String[] verseFragments = {
                "a Partridge in a Pear Tree.\n",
                "two Turtle Doves,",
                "three French Hens,",
                "four Calling Birds,",
                "five Gold Rings,",
                "six Geese-a-Laying,",
                "seven Swans-a-Swimming,",
                "eight Maids-a-Milking,",
                "nine Ladies Dancing,",
                "ten Lords-a-Leaping,",
                "eleven Pipers Piping,",
                "twelve Drummers Drumming,"
        };

        return verseFragments[verseNumber - 1];
    }

    private String verseNumberWord(int verseNumber) {
        String[] verseNumbers = {
                "first",
                "second",
                "third",
                "fourth",
                "fifth",
                "sixth",
                "seventh",
                "eighth",
                "ninth",
                "tenth",
                "eleventh",
                "twelfth"
        };

        return verseNumbers[verseNumber - 1];
    }

    private String verseIntro(int verseNumber) {
        return "On the " + verseNumberWord(verseNumber) + " day of Christmas my true love gave to me: ";
    }
}
