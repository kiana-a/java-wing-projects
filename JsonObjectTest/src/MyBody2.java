import com.google.gson.JsonObject;

/**
 * Created by kiana on 2/18/18.
 */
public class MyBody2 {
    private String name;

    public MyBody2(JsonObject object) {
        this.name = object.get("name") != null ? object.get("name").getAsString() : "";
    }

    public MyBody2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}