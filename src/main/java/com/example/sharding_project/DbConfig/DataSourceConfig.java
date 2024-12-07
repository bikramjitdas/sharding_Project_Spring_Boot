package com.example.sharding_project.DbConfig;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
class DataSourceConfig{
	
	@Autowired
	private Environment env;
	@Bean(name ="dataSourceRouter")
	public DataSource dataSourceRouter() {
		Map<Object,Object> targetdataSource = new HashMap<>();
		DataSource dbserver1 = DataSourceBuilder.create()
							   .url(env.getProperty("spring.datasource1.url"))
							   .username(env.getProperty("spring.datasource1.username"))
							   .password(env.getProperty("spring.datasource1.password"))
							   .build();
		DataSource dbserver2 = DataSourceBuilder.create()
				   .url(env.getProperty("spring.datasource2.url"))
				   .username(env.getProperty("spring.datasource2.username"))
				   .password(env.getProperty("spring.datasource2.password"))
				   .build();
		targetdataSource.put(DataSourceEnum.DB_SERVER1,dbserver1);
		targetdataSource.put(DataSourceEnum.DB_SERVER2, dbserver2);
		
		CustomDataSourceRouter router = new CustomDataSourceRouter();
		router.setTargetDataSources(targetdataSource);
		router.setDefaultTargetDataSource(dbserver1);
		return router;
	}
}