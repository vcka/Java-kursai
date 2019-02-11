public enum Currency {
    $(0.887309),
    LT(0.289620),
    €(1.0);

    private double rate;

    Currency(Double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
