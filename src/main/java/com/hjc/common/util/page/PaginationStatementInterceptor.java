package com.hjc.common.util.page;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;

import java.sql.Connection;
import java.util.Properties;
/*
* 自定义实现分页查询预先,需要包装查询列表参数需要Map，put(Pageable,"") 。并注释掉spring-dao.xml mybatis-config.xml配置
* 注释掉，可以使用
* */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
public class PaginationStatementInterceptor implements Interceptor {

    private final static Logger log = LoggerFactory.getLogger(PaginationStatementInterceptor.class);

    /*@Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        ParameterHandler parameterHandler = statementHandler.getParameterHandler();
        Object parameterObject = parameterHandler.getParameterObject();

        Pageable pagination = null;

        if(parameterObject instanceof MapperMethod.ParamMap){

            MapperMethod.ParamMap paramMapObject = (MapperMethod.ParamMap)parameterObject ;


            if(paramMapObject != null){
                for(Object key : paramMapObject.keySet()){
                    if(paramMapObject.get(key) instanceof  Pageable){
                        pagination = (Pageable) paramMapObject.get(key);
                        break;
                    }
                }
            }
        }

        if (pagination != null) {

            MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(),null);
            Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
            Dialect.Type databaseType;

            try {
                databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
            } catch (Exception e) {
                throw new Exception("Generate SQL: Obtain DatabaseType Failed!");
            }

            Dialect dialect = null;
            switch (databaseType) {
                case MYSQL:
                    dialect = new MySql5Dialect();
                    break;
                case ORACLE:
//                    dialect = new OracleDialect();
                    break;
                case SQLSERVER:
//                    dialect = new SQLServer2005Dialect();
                    break;
            }

            String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

            metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, pagination.getPageNumber() * pagination.getPageSize(), pagination.getPageSize()));

            if (log.isDebugEnabled()) {
                BoundSql boundSql = statementHandler.getBoundSql();
                log.debug("Generate SQL : " + boundSql.getSql());
            }

            return invocation.proceed();
        }

        return invocation.proceed();
    }*/

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
        Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
        Dialect.Type databaseType;

        try {
            databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
        } catch (Exception e) {
            throw new Exception("Generate SQL: Obtain DatabaseType Failed!");
        }

        Dialect dialect = null;
        switch (databaseType) {
            case MYSQL:
                dialect = new MySql5Dialect();
                break;
            case ORACLE:
//                    dialect = new OracleDialect();
                break;
            case SQLSERVER:
//                    dialect = new SQLServer2005Dialect();
                break;
        }

        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

        metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, 0, 10));

        if (log.isDebugEnabled()) {
            BoundSql boundSql = statementHandler.getBoundSql();
            log.debug("Generate SQL : " + boundSql.getSql());
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
