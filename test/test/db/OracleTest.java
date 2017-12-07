package test.db;

import org.junit.Test;
import test.bean.DictEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleTest {
    // TODO: 2017/12/6 0006 优化哈，数据库迁移表数据问题。考虑用数据库连接池，且优化代码增强复用性，移植性。考虑注释加反射机制注入sql对应bean的值
    //关键点在于：PreparedStatement 设值问题。参考mybatis映射对象问题

    private static final String oracleDriverName = "oracle.jdbc.driver.OracleDriver";
    private static final String oracleUrl = "jdbc:oracle:thin:@192.168.7.202:1521:xjtest";
    private static final String oracleUserName = "beanoper";
    private static final String oraclePassword = "beanopertest";

    private static final String mysqlDriverName = "com.mysql.jdbc.Driver";
    private static final String mysqlUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
    private static final String mysqlUserName = "root";
    private static final String mysqlPassword = "123456";
    
    /**
     * 一个非常标准的连接Oracle数据库的示例代码
     */
    @Test
    public void testOracle()
    {
        List<DictEntity> list = new ArrayList<>();
        Connection oracleCon = null;// 创建一个数据库连接
        Connection mysqlCon = null;
        PreparedStatement oraclePre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        PreparedStatement mysqlPre = null;
        ResultSet result = null;// 创建一个结果集对象
        try {
            oracleCon = connection(oracleDriverName, oracleUrl, oracleUserName, oraclePassword);
            mysqlCon = connection(mysqlDriverName, mysqlUrl, mysqlUserName, mysqlPassword);
            System.out.println("连接成功！");
//            String sql = "select DICT.type from SYS_DICT dict where INSTR(DICT.TYPE, 'DZ')>0 GROUP BY DICT.type";// 预编译语句，“？”代表参数
            String oracleSql = "select * from sys_dict where instr(type,'DZ') > 0";
            oraclePre = oracleCon.prepareStatement(oracleSql);// 实例化预编译语句
//            pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
            result = oraclePre.executeQuery();// 执行查询，注意括号中不需要再加参数

            while (result.next()){
                // 当结果集不为空时
                DictEntity dictEntity = new DictEntity();

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(result.getString("id")+" ").append(
                result.getString("value") +" ").append(
                result.getString("label")+" ").append(
                result.getString("TYPE")+" ").append(
                result.getString("DESCRIPTION")+" ").append(
                result.getInt("SORT")+" ").append(
                result.getString("PARENT_ID")+" ").append(
                result.getInt("STATUS")+" ").append(
                result.getString("REMARKS")+" ").append(
                result.getString("CREATE_ID")+" ").append(
                result.getDate("CREATE_TIME")+" ").append(
                result.getString("UPDATE_ID")+" ").append(
                result.getDate("UPDATE_TIME")+" ").append(
                result.getString("IS_LEVEL"));


                dictEntity.setId(result.getString("id"));
                dictEntity.setValue(result.getString("value"));
                dictEntity.setLabel(result.getString("label"));
                dictEntity.setType(result.getString("TYPE"));
                dictEntity.setDescription(result.getString("DESCRIPTION"));
                dictEntity.setSort(result.getInt("SORT"));
                dictEntity.setParentId(result.getString("PARENT_ID"));
                dictEntity.setStatus(result.getInt("STATUS"));
                dictEntity.setRemarks(result.getString("REMARKS"));
                dictEntity.setCreateId(result.getString("CREATE_ID"));
                dictEntity.setCreateTime(result.getDate("CREATE_TIME"));
                dictEntity.setUpdateId(result.getString("UPDATE_ID"));
                dictEntity.setUpdateTime(result.getDate("UPDATE_TIME"));
                dictEntity.setIsLevel(result.getString("IS_LEVEL"));

                list.add(dictEntity);
                System.out.println("返回的值对象为："+stringBuilder.toString());
            }

            int num = 0;
            for (DictEntity dictEntity : list){
                String mysqlSql = "INSERT INTO sys_dict (ID, VALUE, LABEL, TYPE, DESCRIPTION, SORT, PARENT_ID, STATUS, REMARKS," +
                        " CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME, IS_LEVEL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                mysqlPre = mysqlCon.prepareStatement(mysqlSql);
                mysqlPre.setString(1,dictEntity.getId());
                mysqlPre.setString(2, dictEntity.getValue());
                mysqlPre.setString(3,dictEntity.getLabel());
                mysqlPre.setString(4,dictEntity.getType());
                mysqlPre.setString(5,dictEntity.getDescription());
                mysqlPre.setInt(6,dictEntity.getSort());
                mysqlPre.setString(7,dictEntity.getParentId());
                mysqlPre.setInt(8,dictEntity.getStatus());
                mysqlPre.setString(9,dictEntity.getRemarks());
                mysqlPre.setString(10,dictEntity.getCreateId());
                mysqlPre.setDate(11,dictEntity.getCreateTime());
                mysqlPre.setString(12,dictEntity.getUpdateId());
                mysqlPre.setDate(13,dictEntity.getUpdateTime());
                mysqlPre.setString(14,dictEntity.getIsLevel());

                int i = mysqlPre.executeUpdate();
                if (i == 1) {
                    num++;
                    System.out.println("插入"+dictEntity.getLabel()+"成功,总成功条数："+num);
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (oraclePre != null)
                    oraclePre.close();
                if (mysqlPre != null) {
                    mysqlPre.close();
                }
                if (mysqlCon != null) {
                    mysqlCon.close();
                }
                if (oracleCon != null)
                    oracleCon.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public Connection connection(String driverClassName, String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);// 加载Oracle驱动程序
        System.out.println("开始尝试连接数据库！");
        Connection con = DriverManager.getConnection(url, user, password);// 获取连接
        return con;
    }
}
