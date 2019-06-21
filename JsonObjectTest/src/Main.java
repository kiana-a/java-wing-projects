import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by kiana on 2/18/18.
 */
public class Main {
    public static void main(String[] args) {
        MyClass<MyBody2> myClass = new MyClass<>("myBody2",new MyBody2("kiana"));
        String json = new Gson().toJson(myClass);
        System.out.println(json);

//        MyClass myClass2 = new MyClass("name",new MyBody2("my type"));
//        String json2 = new Gson().toJson(myClass2);
//        System.out.println(json2);

        JsonObject jsonObject = new Gson().fromJson(json,JsonObject.class);

        String type = jsonObject.get("type").getAsString();
        JsonObject body = jsonObject.get("body").getAsJsonObject();

        if (type.equals("myBody")){
            MyBody myBody = new MyBody(body);
            System.out.println(myBody.getCode());
        }else if (type.equals("myBody2")){
            MyBody2 myBody2 = new MyBody2(body);
            System.out.println(myBody2.getName());
        }
    }
}
