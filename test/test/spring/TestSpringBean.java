package test.spring;

import com.hjc.spring.bean.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * Created by Administrator on 2017/11/1 0001.
 */
public class TestSpringBean{
    @Test
    public void testSimpleLoad() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        Assert.assertEquals("testStr",bean.getTestStr());
        System.out.println(bean.getTestStr());
    }

    @Test
    public void testInstantiate(){
        MyTestBean mtb = BeanUtils.instantiateClass(MyTestBean.class);
        System.out.println(mtb.getTestStr());
    }

    @Test
    public void printClasspath(){
        System.out.println(this.getClass().getResource(""));
    }

    @Test
    public void testString(){
        array(null);
    }

    private void array(String... a){

    }

    public void print(){
        System.out.println("总资产：  88268.45");
        System.out.println("支出：    36880.54");
        System.out.println("剩余资产：51387.91");
        /**
         *
         * 收入
         20171025 10140
         20170726 32000
         20170725 30000
         20170109 10000
         20161108 100
         20161108 3028.45
         20161108 3000
        *支出
         20171004 6149  还款借支付宝借呗5000问题在于借呗的5000块钱去向不明？？？？
         20170929 10000 总借建哥15000 已还
         20170926 10000 包含620000还款5402.26
         20170825 5402.34
         20170121 1000
         20161210 1000
         20161121 2716.82
         20161112 612.38
         * 总资产包含62000+10000以上的资产
         * 支出只能包含还款5402.26 已还3期 为 16206.78
         * 64827.12 剩余应还 48620.34
         * 本来也支出 15000
         *本因剩余 58620.34
         *         52518.29
         *        差6102.05
         */
        System.out.println("支出：收益：平衡");
        /**
         * 6月份 总资产 11029.8
         * 7月份        73074.99
         * 8月份        68001.21
         * 9月份        48305.84
         * 1107        52518.29
         * 陆金所 5000块去向 549.83 还款于 京东
         * 4490.17
         * 转账5870 余 1490.17元了。上周又取出100元 为1390.17
         * 5000 转1000到支付宝 然后 又 转给 对的账总算平了
         */

    }
}

