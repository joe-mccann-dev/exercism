import java.util.HashMap;

public class Blackjack {

  private HashMap<String, Integer> cardValues = new HashMap<>();

  public Blackjack() {
    // calls private method below that populates a hashmap
    // uses more space but easier to update.
    setCardValues();
  }

  public int parseCard(String card) {
    if (this.cardValues.get(card) == null)
      return 0;

    return this.cardValues.get(card);
  }

  public boolean isBlackjack(String card1, String card2) {
    return parseCard(card1) + parseCard(card2) == 21;
  }

  public String largeHand(boolean isBlackjack, int dealerScore) {
    // two aces; split;
    if (!isBlackjack)
      return "P";
    // have blackjack hand but dealer showing a 10 or 11 value card; stand;
    if (isBlackjack && dealerScore >= 10)
      return "S";

    // have blackjack and dealer showing low card; win;
    return "W";
  }

  public String smallHand(int handScore, int dealerScore) {
    // don't hit if you have 17 or higher; stand
    if (handScore >= 17)
      return "S";
    // hit if you have 11 or less, or if you have between 12 and 16 and dealer showing >= 7;
    if (handScore <= 11 ||
        ((handScore >= 12 && handScore <= 16) && dealerScore >= 7))
      return "H";

    return "S";
  }

  // FirstTurn returns the semi-optimal decision for the first turn, given the
  // cards of the player and the dealer.
  // This function is already implemented and does not need to be edited. It pulls
  // the other functions together in a
  // complete decision tree for the first turn.
  public String firstTurn(String card1, String card2, String dealerCard) {
    int handScore = parseCard(card1) + parseCard(card2);
    int dealerScore = parseCard(dealerCard);

    if (20 < handScore) {
      return largeHand(isBlackjack(card1, card2), dealerScore);
    } else {
      return smallHand(handScore, dealerScore);
    }
  }

  private void setCardValues() {
    this.cardValues.put("ace", 11);
    this.cardValues.put("two", 2);
    this.cardValues.put("three", 3);
    this.cardValues.put("four", 4);
    this.cardValues.put("five", 5);
    this.cardValues.put("six", 6);
    this.cardValues.put("seven", 7);
    this.cardValues.put("eight", 8);
    this.cardValues.put("nine", 9);
    this.cardValues.put("ten", 10);
    this.cardValues.put("jack", 10);
    this.cardValues.put("queen", 10);
    this.cardValues.put("king", 10);
  }
}
