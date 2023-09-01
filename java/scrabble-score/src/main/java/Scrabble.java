class Scrabble {

  int score = 0;

  Scrabble(String word) {
    setScore(word);
  }

  void setScore(String word) {
    for (char ch : word.toCharArray())
      this.score += getLetterScore(ch);
  }

  int getScore() {
    return this.score;
  }

  int getLetterScore(char letter) {
    letter = Character.toLowerCase(letter);
    return switch (letter) {
      case 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't' -> 1;
      case 'd', 'g' -> 2;
      case 'b', 'c', 'm', 'p' -> 3;
      case 'f', 'h', 'v', 'w', 'y' -> 4;
      case 'k' -> 5;
      case 'j', 'x' -> 8;
      case 'q', 'z' -> 10;
      default -> 0;
    };
  }

}
