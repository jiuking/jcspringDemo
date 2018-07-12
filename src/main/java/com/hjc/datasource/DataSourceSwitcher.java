package com.hjc.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author : Administrator
 * @date : 2018/7/12 0012 17:17
 * @description : Spring多数据源切换
 */
public class DataSourceSwitcher extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger("INTERACTIVE_LOGGER");

    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();

    public static void clearDataSourceType() {
        LOGGER.debug("thread:{},remove,dataSource:{}",Thread.currentThread().getName());
        dataSourceKey.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String s = dataSourceKey.get();
        LOGGER.debug("thread:{},determine,dataSource:{}",Thread.currentThread().getName(),s);
        return s;
    }

    public static void setDataSourceKey(String dataSource) {
        LOGGER.debug("thread:{},set,dataSource:{}",Thread.currentThread().getName(),dataSource);
        dataSourceKey.set(dataSource);
    }
}
