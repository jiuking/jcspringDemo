package test.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

public class TransferDBToRedisTest {
    /**
     * @Author: Administrator
     * @Description: 测试数据迁移到redis脚本
     * @param:
     * @Date: 13:30 2017/12/6 0006
     * @return: void
     * @throws:
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        //分组查询出key值，并以key值作为redis的key，value的值为数据库中对应的dict entity
        //first,获取数据库连接并查询出对应的数据
        //second,导入数据到redis中，按照key为sys_dict中的type，value为sysDict实例对象。且存储至
        //finally,查看是否成功。
        redisTemplate.boundHashOps("DZ").putAll(new HashMap());

    }
}
