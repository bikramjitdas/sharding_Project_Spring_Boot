package com.example.sharding_project.DbConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomDataSourceRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDatabase();
	}
		
}
