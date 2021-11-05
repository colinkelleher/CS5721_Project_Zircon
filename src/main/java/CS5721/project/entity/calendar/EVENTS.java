package CS5721.project.entity.calendar;

public enum EVENTS {
    CREATE_REQUEST("createRequest"),
    VALIDATE_REQUEST("validateRequest");

    private final String value;

    EVENTS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
