class Darts {
    int score(double xOfDart, double yOfDart) {
        double landing = Math.sqrt((xOfDart * xOfDart) + (yOfDart * yOfDart));

        if (landing <= 1.0)
            return 10;
        if (landing <= 5.0)
            return 5;
        if (landing <= 10)
            return 1;

        return 0;
    }
}
