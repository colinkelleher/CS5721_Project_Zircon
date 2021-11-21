package CS5721.project.entity;

public enum RATES {
    OVERTIME_RATE(16),
    REGULAR_RATE(10.20)
    ;

    private final double value;

    RATES(double value) {

        this.value = value;
    }

    public double getValue() { return value;}
}
