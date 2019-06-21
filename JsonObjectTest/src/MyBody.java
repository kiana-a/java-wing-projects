import com.google.gson.JsonObject;

/**
 * Created by kiana on 2/18/18.
 */
public class MyBody {
    private Integer code;

    public MyBody(JsonObject object) {
        this.code = object.get("code") != null ? object.get("code").getAsInt() : null;
    }

    public MyBody(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
