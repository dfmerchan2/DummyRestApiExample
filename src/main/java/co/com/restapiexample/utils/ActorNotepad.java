package co.com.restapiexample.utils;

public enum ActorNotepad {
    STATUS("status"),
    MESSAGE("message"),
    NAME("name"),
    SALARY("salary"),
    AGE("age"),
    ID("id")
    ;

    private final String key;

    ActorNotepad(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
