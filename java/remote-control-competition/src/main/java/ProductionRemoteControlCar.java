class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

  private int distanceTravelled = 0;
  private int numberOfVictories = 0;

  public void drive() {
    this.distanceTravelled += 10;
  }

  public int getDistanceTravelled() {
    return this.distanceTravelled;
  }

  public int getNumberOfVictories() {
    return numberOfVictories;
  }

  public void setNumberOfVictories(int numberOfVictories) {
    this.numberOfVictories = numberOfVictories;
  }

  @Override
  public int compareTo(ProductionRemoteControlCar otherCar) {
    return otherCar.numberOfVictories - this.numberOfVictories;
  }
}
