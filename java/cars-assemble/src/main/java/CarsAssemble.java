public class CarsAssemble {

  private final static double CARS_PER_HOUR = 221.0;

  public double productionRatePerHour(int speed) {
    if (speed == 10)
      return getHourlyRate(speed, 0.77);
    if (speed == 9)
      return getHourlyRate(speed, 0.80);
    if (speed > 4)
      return getHourlyRate(speed, 0.90);
    
    return getHourlyRate(speed, 1.0);
  }

  public int workingItemsPerMinute(int speed) {
    return (int) productionRatePerHour(speed) / 60  ;
  }

  private double getHourlyRate(int speed, double successRate) {
    return CARS_PER_HOUR * speed * successRate;
  }
}
