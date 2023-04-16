package com.brunner.service.util;

import java.io.IOException;
import java.util.HashMap;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSession;

public class LogUtil {

	public static String getSqlLog(SqlSession session, String sqlId, HashMap<String, Object> params) throws IOException {
		MappedStatement ms = session.getConfiguration().getMappedStatement(sqlId);
		BoundSql boundSql = ms.getBoundSql(params); // pass in parameters for the SQL statement
		
		StringBuilder sqlLog = new StringBuilder("========================================");
		sqlLog.append("\n");
		sqlLog.append(boundSql.getSql());
		sqlLog.append("\n----------------------------------------");
		for(int i = 0; i < boundSql.getParameterMappings().size(); i++) {
			sqlLog.append("\n");
			sqlLog.append(boundSql.getParameterMappings().get(i).getProperty());
			sqlLog.append(":");
			sqlLog.append(params.get(boundSql.getParameterMappings().get(i).getProperty()));
		}
		sqlLog.append("\n========================================");
		return sqlLog.toString();
	}
}
