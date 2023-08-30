
class BirdWatcher {
    private final int[] birdsPerDay;
    private final int todayIndex;


    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.todayIndex = birdsPerDay.length - 1;
    }

    public int[] getLastWeek() {
        return this.birdsPerDay;
    }

    public int getToday() {
        return this.birdsPerDay[todayIndex];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[todayIndex] += 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int birdCount : this.birdsPerDay)
          if (birdCount == 0)
            return true;

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int dailyCount = 0;
        for (int dayIndex = 0; (dayIndex < numberOfDays) && (dayIndex < 7); dayIndex++)
            dailyCount += this.birdsPerDay[dayIndex];
        
        return dailyCount;
    }

    public int getBusyDays() {
        int numberOfBusyDays = 0;
        for (int birdCount : this.birdsPerDay)
          if (birdCount > 4)
            numberOfBusyDays += 1;
        
        return numberOfBusyDays;
    }
}
