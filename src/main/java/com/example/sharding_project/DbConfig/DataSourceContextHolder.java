package com.example.sharding_project.DbConfig;

public class DataSourceContextHolder{
	
	public static ThreadLocal<DataSourceEnum> CONTEXT = new ThreadLocal<>();
	
	public static void set(DataSourceEnum datasourceEnum) {
		CONTEXT.set(datasourceEnum);
	}
	
	public static DataSourceEnum getDatabase() {
		return CONTEXT.get();
	}
	
	public static void clear() {
		CONTEXT.remove();
	}

}