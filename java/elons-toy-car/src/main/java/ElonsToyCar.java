public class ElonsToyCar {

  private int batteryRemaining = 100;
  private int metersDriven = 0;

  public static ElonsToyCar buy() {
    return new ElonsToyCar();
  }

  public String distanceDisplay() {
    return "Driven " + this.metersDriven + " meters";
  }

  public String batteryDisplay() {
    String batteryDisplay = this.batteryRemaining == 0 ? "empty" : "at " + this.batteryRemaining + "%";
    return String.format("Battery %s", batteryDisplay);
  }

  public void drive() {
    if (batteryRemaining == 0)
      return;

    this.metersDriven += 20;
    this.batteryRemaining -= 1;
  }

}
