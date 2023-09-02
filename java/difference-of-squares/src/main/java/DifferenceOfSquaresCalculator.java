class DifferenceOfSquaresCalculator {

  int computeSquareOfSumTo(int input) {
    boolean inputIsEven = input % 2 == 0;
    int sum = (input + 1) * (input / 2);

    // account for integer division of odd number by adding number back to sum;
    sum = inputIsEven ? sum : sum + (input / 2) + 1;

    return sum * sum;
  }

  
  //  Faulhaber's formula
  // 1^2 + 2^2 + 3^2 + ... n^2 = n(n + 1)(2n + 1)) / 6
  int computeSumOfSquaresTo(int input) {
    int numerator = input * (input + 1) * (2*input + 1);
    int denominator = 6;
    int result = numerator / denominator;

    return (result);
  }

  int computeDifferenceOfSquares(int input) {
    return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
  }

}
