public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int actualMinutes) {
        return expectedMinutesInOven() - actualMinutes;
    }

    public int preparationTimeInMinutes(int amountLayers) {
        int prepMinutesPerLayer = 2;
        return (amountLayers * prepMinutesPerLayer);
    }

    public int totalTimeInMinutes(int amountLayers, int actualMinutes) {
        return preparationTimeInMinutes(amountLayers) + actualMinutes;
    }
}
