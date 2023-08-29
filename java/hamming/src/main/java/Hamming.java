public class Hamming {
  private String leftStrand;
  private String rightStrand;

  public Hamming(String leftStrand, String rightStrand) {
    if (leftStrand.isEmpty() && !rightStrand.isEmpty())
      throw new IllegalArgumentException("left strand must not be empty.");

    if (rightStrand.isEmpty() && !leftStrand.isEmpty())
      throw new IllegalArgumentException("right strand must not be empty.");

    if (leftStrand.length() != rightStrand.length())
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
  }

  public int getHammingDistance() {
    int hammingDistance = 0;

    for (int baseIndex = 0; baseIndex < leftStrand.length(); baseIndex++) {
      if (this.leftStrand.charAt(baseIndex) != this.rightStrand.charAt(baseIndex))
        hammingDistance++;
    }

    return hammingDistance;
  }
}
