package co.com.restapiexample.utils;

public enum ServiceName {
    SERVICE_EMPLOYEES("employee/"),
    SERVICE_ALL_EMPLOYEES("employees"),
    SERVICE_CREATE("create"),
    SERVICE_DELETE("delete/")
    ;

    private final String value;

    ServiceName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
