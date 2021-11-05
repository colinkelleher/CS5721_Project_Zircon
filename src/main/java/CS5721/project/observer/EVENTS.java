package CS5721.project.observer;

public enum EVENTS {
    CREATE_REQUEST("create_request"),
    VALIDATE_REQUEST("validate_request");

    private final String value;

    EVENTS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
