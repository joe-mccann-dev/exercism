class DifferenceOfSquaresCalculator {

  int computeSquareOfSumTo(int input) {
    int sum = 0;
    for (int i = 1; i <= input; i++) {
      sum += i;
    }

    return (sum * sum);
  }

  int computeSumOfSquaresTo(int input) {
    int currentSum = 0;
    int sumOfSquares = 0;
    for (int i = 1; i <= input; i++) {
      currentSum = (i * i);
      sumOfSquares += currentSum;
    }

    return sumOfSquares;
  }

  int computeDifferenceOfSquares(int input) {
    return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
  }

}
