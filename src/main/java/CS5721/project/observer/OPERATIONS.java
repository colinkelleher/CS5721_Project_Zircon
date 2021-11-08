package CS5721.project.observer;

public enum OPERATIONS {
    CREATE_REQUEST("create_request"),
    VALIDATE_REQUEST("validate_request"),
    CREATE_EVENT("create_event");

    private final String value;

    OPERATIONS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
