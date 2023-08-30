class NeedForSpeed {

  private int speed;
  private int batteryDrain;
  private int batteryPercentageRemaining = 100;
  private int distanceDriven = 0;

  public NeedForSpeed(int speed, int batteryDrain) {
    this.speed = speed;
    this.batteryDrain = batteryDrain;
  }

  public boolean batteryDrained() {
    return batteryPercentageRemaining < batteryDrain;
  }

  public int distanceDriven() {
    return this.distanceDriven;
  }

  public void drive() {
    if (batteryDrained())
      return;

    this.distanceDriven += speed;
    this.batteryPercentageRemaining -= batteryDrain;

  }

  public static NeedForSpeed nitro() {
    int nitroSpeed = 50;
    int nitroBatteryDrain = 4;

    return new NeedForSpeed(nitroSpeed, nitroBatteryDrain);
  }
}

class RaceTrack {

  private int distance;

  public RaceTrack(int distance) {
    this.distance = distance;
  }

  public boolean tryFinishTrack(NeedForSpeed car) {
    boolean isFinished = false;
    
    while (car.distanceDriven() < this.distance) {
      car.drive();
      isFinished = car.distanceDriven() == this.distance;
      if (isFinished || car.batteryDrained())
        break;

    }

    return isFinished;
  }
}
