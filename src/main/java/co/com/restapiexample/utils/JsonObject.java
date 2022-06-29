package co.com.restapiexample.utils;

import org.json.JSONObject;

public class JsonObject {

    public static String ofCreateUser(String name, String age, String salary) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("salary", salary);
        jsonObject.put("age", age);
        return jsonObject.toString(2);
    }

    private JsonObject() {
    }

}
