package test.db;

import com.hjc.common.util.SpringContextHolder;
import com.hjc.common.util.migrate.DBConnUtil;
import com.hjc.common.util.migrate.MigrateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.plugin.javascript.navig.LinkArray;
import test.bean.Dict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml","classpath:spring-redis.xml","classpath:spring-mvc.xml"})
public class ReflectDBTest {

    ResourceBundle mysqlRes = ResourceBundle.getBundle("conf/mysql");
    ResourceBundle oracleRes = ResourceBundle.getBundle("conf/oracle");

    @Test
    public void test() throws SQLException {
        ResourceBundle mysqlRes = ResourceBundle.getBundle("conf/mysql");
        ResourceBundle oracleRes = ResourceBundle.getBundle("conf/oracle");
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection mysqlCon = null;
        Connection oracleCon = null;
        try {
            mysqlCon = DBConnUtil.getConnection(getValue(mysqlRes, "driver"),
                    getValue(mysqlRes, "url"), getValue(mysqlRes, "jdbcUsername"), getValue(mysqlRes, "password"));
            oracleCon = DBConnUtil.getConnection(getValue(oracleRes, "driver"),
                    getValue(oracleRes, "url"), getValue(oracleRes, "jdbcUsername"), getValue(oracleRes, "password"));
            String oracleSql = "select * from sys_dict where instr(type,'DZ') > 0";
            //查询数据转换实体类
            preparedStatement = oracleCon.prepareStatement(oracleSql);
            resultSet = DBConnUtil.getQueryResult(preparedStatement);
            List<Dict> list = new ArrayList<>();
            while (resultSet.next()) {
                Dict dict = MigrateUtil.migrate(Dict.class, resultSet);
                list.add(dict);
            }
            String insertSql = "INSERT INTO sys_dict (ID, VALUE, LABEL, TYPE, DESCRIPTION, SORT, PARENT_ID, STATUS, REMARKS,CREATE_ID," +
                    " CREATE_TIME, UPDATE_ID, UPDATE_TIME, IS_LEVEL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //实体类插入sql
            PreparedStatement insert = mysqlCon.prepareStatement(insertSql);
            /*for (Dict dict : list) {//循环插入效率不是很高，考虑批量导入，设置事务
                insert = MigrateUtil.migrate(insert, Dict.class, dict);
                DBConnUtil.getInsertResult(insert);
            }*/

            for (Dict dict : list) {//循环插入效率不是很高，考虑批量导入，设置事务
                insert = MigrateUtil.migrate(insert, Dict.class, dict);
            }
            DBConnUtil.getBatchResult(mysqlCon, insert, list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (preparedStatement != null) {
                preparedStatement.close();
                preparedStatement = null;
            }
            if (mysqlCon != null) {
                mysqlCon.close();
                mysqlCon = null;
            }
            if (oracleCon != null) {
                oracleCon.close();
                oracleCon = null;
            }
            System.out.println("数据库连接已成功关闭");
        }
    }

    private static String getValue(ResourceBundle resourceBundle, String key) {
        return resourceBundle.getString(key);
    }

    @Autowired
    private RedisTemplate<String,Dict> redisTemplate;
    @Test
    public void test2() throws SQLException {
        Connection con = null;
        PreparedStatement keyPreparedStatement = null;
        PreparedStatement valuePreparedStatement = null;
        ResultSet keyResultSet = null;
        ResultSet valueResultSet = null;
        try {
            con = DBConnUtil.getConnection(getValue(oracleRes, "driver"),
                    getValue(oracleRes, "url"), getValue(oracleRes, "jdbcUsername"), getValue(oracleRes, "password"));
//            String oracleSql = "select * from sys_dict where instr(type,'DZ') > 0";
            String keySql = "select TYPE from SYS_DICT where instr(type,'DZ_')>0 group by type";
            keyPreparedStatement = con.prepareStatement(keySql);
            keyResultSet = keyPreparedStatement.executeQuery();
            String concreteSql = "select * from SYS_DICT where type = ?";
            valuePreparedStatement = con.prepareStatement(concreteSql);
            List<String> keys = new ArrayList<>();
            while (keyResultSet.next()) {
                keys.add(keyResultSet.getString("type"));
            }
            for (String key : keys) {
                List<Dict> list = new ArrayList<>();
                valuePreparedStatement.setString(1,key);
                valueResultSet = valuePreparedStatement.executeQuery();
                while (valueResultSet.next()) {
                    Dict dict = MigrateUtil.migrate(Dict.class, valueResultSet);
                    list.add(dict);
                }
                migrateRedis(key,list);
                System.out.println("Redis存储key值为："+key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (keyResultSet != null) {
                keyResultSet.close();
                keyResultSet = null;
            }
            if (valueResultSet != null) {
                valueResultSet.close();
                valueResultSet = null;
            }
            if (keyPreparedStatement != null) {
                keyPreparedStatement.close();
                keyPreparedStatement = null;
            }
            if (valueResultSet != null) {
                valueResultSet.close();
                valueResultSet = null;
            }

            if (con != null) {
                con.close();
                con = null;
            }
        }
    }

    private void migrateRedis(String key ,List list){
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    @Test
    public void testGetRedis() {
        List<Dict> list = redisTemplate.opsForList().range("DZ_INDUSTRY_102",0,-1);
        System.out.println(list);
        System.out.println(redisTemplate.opsForList().size("DZ_INDUSTRY_102"));
        for (Object dict : list) {
            System.out.println(((Dict)dict).getLabel());
        }
    }
}
