package com.hjc.common.util.migrate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Row {
    //索引 第几个
    int index();

    //对应的数据库 列名
    String rowName();

    //列名对应的字段类型 未使用到
//    Class<?> rowClass();
}
