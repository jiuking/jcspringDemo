package com.hjc.common.util.page;

public abstract class Dialect {
    public static enum Type {
        MYSQL, ORACLE, SQLSERVER
    }

    public abstract String getLimitString(String querySqlString, int offset, int limit);

    public abstract String getCountString(String querySqlString);
}
