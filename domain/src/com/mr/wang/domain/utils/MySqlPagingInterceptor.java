package com.mr.wang.domain.utils;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

//注解说明该类事拦截器
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }))
public class MySqlPagingInterceptor extends AbstractPagingInterceptor {

	/**
	 * 改造sql变成查询总数的sql
	 */
	@Override
	protected String getSelectTotalSql(String targetSql) {
		String sql = targetSql.toLowerCase();
		StringBuilder sqlBuilder = new StringBuilder(sql);
		int orderByPos = 0;
		if ((orderByPos = sqlBuilder.lastIndexOf(ORDER_BY)) != -1) {
			sqlBuilder.delete(orderByPos, sqlBuilder.length());
		}
		if (sqlBuilder.indexOf(UNION) != -1) {
			sqlBuilder.insert(0, "select count(1) as _count from ( ").append(" ) as _alias");
			return sqlBuilder.toString();
		}
		int fromPos = sqlBuilder.indexOf(FROM);
		if (fromPos != -1) {
			sqlBuilder.delete(0, fromPos);
			sqlBuilder.insert(0, "select count(1) as _count ");
		}
		return sqlBuilder.toString();
	}

	/**
	 * 改造sql变成支持分页的sql
	 */
	@Override
	protected String getSelectPagingSql(String targetSql, PagingBounds bounds) {
		String sql = targetSql.toLowerCase();
		StringBuilder sqlBuilder = new StringBuilder(sql);
		sqlBuilder.append(" keyid  limit " + bounds.getSelectCount() + " , " + bounds.getOffset());
		return sqlBuilder.toString();
	}

}
