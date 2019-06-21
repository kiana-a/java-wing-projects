/**
 * Created by kiana on 2/18/18.
 */
public class MyClass<T> {
    private String type;
    private T body;

    public MyClass(String type, T body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
