package com.hjc.common.util.migrate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

public final class DBConnUtil {
    private DBConnUtil(){

    }

    private static final Logger logger = LoggerFactory.getLogger(DBConnUtil.class);

    public static Connection getConnection(String driver, String url,String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);// 获取连接
        System.out.println("连接数据库成功！");
        logger.info("连接数据库{}成功！",url);
        return con;
    }

    /**
     * @Author: Administrator
     * @Description: 返回查询结果集
     * @param: preparedStatement
     * @Date: 17:23 2017/12/7 0007
     * @return: java.sql.ResultSet
     * @throws:
     */
    public static ResultSet getQueryResult(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public static int getUpdateResult(PreparedStatement preparedStatement) throws SQLException {
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public static int getInsertResult(PreparedStatement preparedStatement) throws SQLException {
        return getUpdateResult(preparedStatement);
    }

    public static <T> int getBatchResult(Connection con,PreparedStatement preparedStatement,List<T> list) throws SQLException {
        con.setAutoCommit(false);
        for (T obj : list) {
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        con.commit();
        return 1;
    }
}
