package test;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Getter
@Setter
public class UserBean {
    private Integer id;
    private int age;
    private String name;
    private String address;

    public UserBean(){
        System.out.println("实例化");
    }

    @Override
    public String toString() {
        return name+address;
    }
}
