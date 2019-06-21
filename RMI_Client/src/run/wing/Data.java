package run.wing;

import java.io.Serializable;

/**
 * Created by kiana on 12/14/17.
 */
public class Data implements Serializable {
    private Integer a;
    private Integer b;

    public Data(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
