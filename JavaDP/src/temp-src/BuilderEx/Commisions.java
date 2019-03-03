package BuilderEx;

public enum Commisions {

    REGULAR_COMMISION(10),
    GOLD_COMMISION(5),
    PLATINUM_COMMISION(0);

    private double value;

    Commisions(double value) {
        this.value = value;
    }
}
