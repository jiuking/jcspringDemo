package com.hjc.common.util.migrate;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class MigrateUtil {

    public static final <T> T migrate(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        //优化
        return null;
    }

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

    private static <T> void merge(Row row, T obj, Field field,ResultSet resultSet) throws IllegalAccessException, SQLException {
        System.out.println(field.getType().toString().contains("String"));
        Object value = new Object();
        int index = row.index();
        String rowName = row.rowName();
        switch (field.getType().toString()){
            case "java.lang.String":
                value = resultSet.getString(rowName);
                break;
            case "java.lang.Integer":
                value = resultSet.getInt(rowName);
                break;
            case "java.util.Date":
                value = resultSet.getDate(rowName);
        }
        field.set(obj,value);
    }
}
