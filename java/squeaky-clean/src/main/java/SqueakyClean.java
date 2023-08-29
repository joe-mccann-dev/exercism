import static java.lang.Character.isISOControl;
import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;
import static java.lang.Character.toUpperCase;

class SqueakyClean {

  static String clean(String identifier) {

    StringBuilder stringBuilder = new StringBuilder();
    char[] charArray = identifier.toCharArray();
    boolean prevHyphen = false;

    for (char currentChar : charArray) {
      if (isISOControl(currentChar))
        stringBuilder.append("CTRL");
      else if (isWhitespace(currentChar))
        stringBuilder.append("_");
      else if (prevHyphen && isLetter(currentChar))
        stringBuilder.append(toUpperCase(currentChar));
      else if (!isLowerCaseGreek(currentChar) && isLetter(currentChar))
        stringBuilder.append(currentChar);

      prevHyphen = currentChar == '-';
    }

    return stringBuilder.toString();
  }

  private static boolean isLowerCaseGreek(char c) {
    return c >= 'α' && c <= 'ω';
  }
}
