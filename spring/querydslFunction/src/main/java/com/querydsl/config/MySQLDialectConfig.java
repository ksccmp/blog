package com.querydsl.config;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

public class MySQLDialectConfig extends MySQLDialect {
	
	public MySQLDialectConfig() {
		super();
		
		// 함수 등록
		this.registerFunction("get_function_test", new StandardSQLFunction("get_function_test", new StringType()));
	}
}
