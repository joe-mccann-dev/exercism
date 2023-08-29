class MicroBlog {

  static final short MAX_POST_LENGTH = 5;

  public String truncate(String input) {
    if (input.length() <= 5)
      return input;

    StringBuilder output = new StringBuilder();

    int codePoint = 0;
    int inputIndex = 0;
    int currentLength = 0;

    while (inputIndex < input.length()) {
      if (currentLength == MAX_POST_LENGTH)
        break;
      
      codePoint = input.codePointAt(inputIndex);
      int charCount = Character.charCount(codePoint);
      // set index to proper location
      // important if charCount > 1
      inputIndex += charCount;

      output.appendCodePoint(codePoint);
      currentLength++;
    }

    return output.toString();
  }
}
