class RotationalCipher {

    public int shiftKey;

    public final static int LOWERCASE_A = 97;
    public final static int LOWERCASE_Z = 122;
    public final static int UPPERCASE_A = 65;
    public final static int UPPERCASE_Z = 90;
    public final static int ALPHABET_SIZE = 26;

    public RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public String rotate(String data) {
        return shiftKey >= 0 ? rotateForward(data) : rotateBackward(data);
    }

    // handles shiftKey >= 0
    private String rotateForward(String data) {
        String result = "";
        char[] dataCharacters = data.toCharArray();
        for (char ch : dataCharacters) {
            int charCode = (int) ch;

            if (isUpperCaseLetter(charCode))
                charCode = codeShiftedForward(charCode, UPPERCASE_A);
            else if (isLowerCaseLetter(charCode))
                charCode = codeShiftedForward(charCode, LOWERCASE_A);

            result += Character.toString(charCode);
        }

        return result;
    }

    // handles shiftKey < 0;
    // test you can add:
    // @Test
    // public void  rotateBackward() {
    //     rotationalCipher = new RotationalCipher(-5);
    //     Assert.assertEquals("Hello, World!", rotationalCipher.rotate("Mjqqt, Btwqi!"));
    // }
    private String rotateBackward(String data) {
        String result = "";
        char[] dataCharacters = data.toCharArray();

        for (char ch : dataCharacters) {
            int charCode = (int) ch;
            if (isUpperCaseLetter(charCode))
                charCode = codeShiftedBackward(charCode, UPPERCASE_A);
            else if (isLowerCaseLetter(charCode))
                charCode = codeShiftedBackward(charCode, LOWERCASE_A);

            result += Character.toString(charCode);
        }

        return result;
    }

    private boolean isUpperCaseLetter(int charCode) {
        return charCode >= UPPERCASE_A && charCode <= UPPERCASE_Z;
    }

    private boolean isLowerCaseLetter(int charCode) {
        return charCode >= LOWERCASE_A && charCode <= LOWERCASE_Z;
    }

    private int codeShiftedForward(int charCode, int startLetter) {
        return (charCode - startLetter + shiftKey) % ALPHABET_SIZE + startLetter;
    }

    private int codeShiftedBackward(int charCode, int startLetter) {
        return (charCode - startLetter + shiftKey + ALPHABET_SIZE) % ALPHABET_SIZE + startLetter;
    }

}
