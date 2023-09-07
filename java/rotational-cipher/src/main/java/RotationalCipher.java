class RotationalCipher {

    private int shiftKey;

    public final static int LOWERCASE_A = 97;
    public final static int UPPERCASE_A = 65;
    public final static int ALPHABET_SIZE = 26;

    public RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    // handles shiftKey >= 0 && shiftKey < 0;
    public String rotate(String data) {
        StringBuilder result = new StringBuilder();
        char[] dataCharacters = data.toCharArray();

        for (char ch : dataCharacters) {
            int charCode = (int) ch;

            if (Character.isUpperCase(ch))
                charCode = codeShifted(charCode, UPPERCASE_A);
            else if (Character.isLowerCase(ch))
                charCode = codeShifted(charCode, LOWERCASE_A);

            result.append((char) charCode);
        }

        return result.toString();
    }

    private int codeShifted(int charCode, int startLetter) {
        if (this.getShiftKey() >= 0)
            return (charCode - startLetter + shiftKey) % ALPHABET_SIZE + startLetter;
        else
            return (charCode - startLetter + shiftKey + ALPHABET_SIZE) % ALPHABET_SIZE + startLetter;
    }

    private int getShiftKey() {
        return this.shiftKey;
    }
}
