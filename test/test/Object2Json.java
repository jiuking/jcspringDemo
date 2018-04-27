package test;

import com.alibaba.fastjson.JSONObject;
import com.hjc.index.entity.ValidateEntity;

public class Object2Json {
    public static void main(String[] args) {
        ValidateEntity validateEntity = new ValidateEntity();
        validateEntity.setBody("主体");
        validateEntity.setMsg("信息");
        validateEntity.setStatus("10");
        System.out.println(JSONObject.toJSONString(validateEntity));
    }
}
