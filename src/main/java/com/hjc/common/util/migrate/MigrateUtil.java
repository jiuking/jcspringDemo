package com.hjc.common.util.migrate;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class MigrateUtil {

    public static final <T> T migrate(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        //优化
        return null;
    }

    /**
     * @Author: Administrator
     * @Description: 合并查询sql结果转换实体类
     * @param: clazz
     * @param: resultSet
     * @Date: 12:35 2017/12/8 0008
     * @return: T
     * @throws:
     */
    public static final <T> T migrate(Class<T> clazz,ResultSet resultSet) throws IllegalAccessException, InstantiationException, SQLException {
        Field[] fields = clazz.getDeclaredFields();
        T obj = clazz.newInstance();
        for(Field field : fields) {
            field.setAccessible(true);
            Row row = field.getAnnotation(Row.class);
            merge(row, obj, field,resultSet);//合并数据。需要sql语句，数据库连接
        }
        return obj;
    }

    private static <T> void merge(Row row, T obj, Field field, ResultSet resultSet) throws IllegalAccessException, SQLException {
        Object value = new Object();
        String rowName = row.rowName();
        switch (field.getType().getName().toString()){
            case "java.lang.String":
                value = resultSet.getString(rowName);
                break;
            case "java.lang.Integer":
                value = resultSet.getInt(rowName);
                break;
            case "java.util.Date":
                value = resultSet.getDate(rowName);
                break;
        }
        field.set(obj,value);
    }

    /**
     * @Author: Administrator
     * @Description: 根据sql转换获取对象实体
     * @param: preparedStatement
     * @param: clazz
     * @param: obj
     * @Date: 11:42 2017/12/8 0008
     * @return: java.sql.PreparedStatement
     * @throws:
     */
    public static final <T> PreparedStatement migrate(PreparedStatement preparedStatement, Class<T> clazz ,T obj) throws IllegalAccessException, InstantiationException, SQLException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Row row = field.getAnnotation(Row.class);
            int index = row.index();
            Object value = field.get(obj);
            switch (field.getType().getName().toString()) {
                case "java.lang.Integer":
                    preparedStatement.setInt(index,(Integer) value);
                    break;
                case "java.lang.String":
                    preparedStatement.setString(index, (String) value);
                    break;
                case "java.util.Date":
                    preparedStatement.setDate(index, (Date) value);
                    break;
            }
        }
        return preparedStatement;
    }

    private Object getAnnoValue(Field filed) {
        Object value = new Object();

        return value;
    }

    public static <T> void test(Class<T> clazz,T obj) throws IllegalAccessException, InstantiationException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Row row = field.getAnnotation(Row.class);
            int index = row.index();
            System.out.println("index:"+index + field.get(obj));
        }
    }
}
