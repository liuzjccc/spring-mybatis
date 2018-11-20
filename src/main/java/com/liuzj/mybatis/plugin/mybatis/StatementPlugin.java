package com.liuzj.mybatis.plugin.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2018-11-20
 *
 * MyBatis 允许使用插件来拦截的方法有一下一些：
 * 1.Executor (update, query, flushStatements, commit, rollback,getTransaction, close, isClosed)
 * 2.ParameterHandler (getParameterObject, setParameters)
 * 3.ResultSetHandler (handleResultSets, handleOutputParameters)
 * 4.StatementHandler (prepare, parameterize, batch, update, query)
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class}) })
public class StatementPlugin implements Interceptor {

    Logger logger = LoggerFactory.getLogger(StatementPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        logger.info("mybatis intercept sql:{}", sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        logger.info("mybatis intercept dialect:{}", dialect);
    }
}
