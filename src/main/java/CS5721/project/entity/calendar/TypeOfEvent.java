package CS5721.project.entity.calendar;

public enum TypeOfEvent {
    REGULAR("regular"),
    OVERTIME("overtime"),
    TRAINING("training");

    private final String value;

    TypeOfEvent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
