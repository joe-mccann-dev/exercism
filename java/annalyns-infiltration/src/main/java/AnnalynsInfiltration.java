class AnnalynsInfiltration {
  public static boolean canFastAttack(boolean knightIsAwake) {
    return !knightIsAwake;
  }

  public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
    return knightIsAwake || archerIsAwake || prisonerIsAwake;
  }

  public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
    return !archerIsAwake && prisonerIsAwake;
  }

  public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake,
      boolean petDogIsPresent) {

    boolean everyoneIsAsleep = !knightIsAwake && !archerIsAwake && !prisonerIsAwake;
    boolean onlyPrisonerIsAwake = !knightIsAwake && !archerIsAwake && prisonerIsAwake;
    boolean onlyKnightIsAwake = knightIsAwake && !archerIsAwake && !prisonerIsAwake;
    boolean onlyArcherIsAsleep = knightIsAwake && !archerIsAwake && petDogIsPresent;

    return (onlyPrisonerIsAwake && !petDogIsPresent) ||
        ((onlyPrisonerIsAwake || onlyKnightIsAwake || onlyArcherIsAsleep || everyoneIsAsleep) &&
            petDogIsPresent);

  }
}
