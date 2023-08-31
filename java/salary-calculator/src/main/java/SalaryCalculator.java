public class SalaryCalculator {

  private final double BASE_SALARY = 1000.00;
  private final double MAX_SALARY = 2000.00;

  public double multiplierPerDaysSkipped(int daysSkipped) {
    double multiplier = 1;
    double penaltyPercent = 0.15;
    double penaltyMultiplier = multiplier - (multiplier * penaltyPercent);

    return daysSkipped > 5 ? penaltyMultiplier : multiplier;
  }

  public int multiplierPerProductsSold(int productsSold) {
    int multiplier = 10;
    int bonusMultiplier = 13;
    int bonusThreshold = 10;

    return productsSold > bonusThreshold ? bonusMultiplier : multiplier;
  }

  public double bonusForProductSold(int productsSold) {
    return productsSold * multiplierPerProductsSold(productsSold);
  }

  public double finalSalary(int daysSkipped, int productsSold) {
    double basePay = BASE_SALARY * multiplierPerDaysSkipped(daysSkipped);
    double bonusPay = bonusForProductSold(productsSold);
    double finalPay = basePay + bonusPay;

    return finalPay > MAX_SALARY ? MAX_SALARY : finalPay;
  }
}
