import com.hjc.common.util.migrate.MigrateUtil;
import org.junit.Test;
import test.UserBean;
import test.bean.Dict;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class ReflectTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        UserBean bean = new UserBean();
        Class userCla = (Class) bean.getClass();
        System.out.println("返回："+test(userCla,bean).toString());
    }
    public static Object test(Class<?> clazz, Object bean) throws IllegalAccessException, InstantiationException {
        Field[] fs = clazz.getDeclaredFields();
        for(int i = 0 ; i < fs.length; i++){
            Field f = fs[i];
            f.setAccessible(true); //设置些属性是可以访问的
            Object val = f.get(bean);//得到此属性的值

            System.out.println("name:"+f.getName()+"\t value = "+val);

            String type = f.getType().toString();//得到此属性的类型
            if (type.endsWith("String")) {
                System.out.println(f.getType()+"\t是String");
                f.set(bean,"XO") ;        //给属性设值
            }else if(type.endsWith("int") || type.endsWith("Integer")){
                System.out.println(f.getType()+"\t是int");
                f.set(bean,12) ;       //给属性设值
            }else{
                System.out.println(f.getType()+"\t");
            }

        }
        return bean;
    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
//        System.out.println(MigrateUtil.migrate(Dict.class).getA());
//       System.out.println(instance.getA());
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        Dict dict = new Dict();
        MigrateUtil.test(Dict.class,dict);
    }
}
