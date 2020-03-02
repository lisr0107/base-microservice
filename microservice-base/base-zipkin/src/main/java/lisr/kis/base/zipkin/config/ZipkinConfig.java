package lisr.kis.base.zipkin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zipkin2.storage.mysql.v1.MySQLStorage;


@Configuration
public class ZipkinConfig {

	/**
	 * 链路跟踪信息报错数据库，数据存储组件配置
	 * @author admin
	 *
	 */
	@Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.newBuilder().datasource(datasource).executor(Runnable::run).build();
    }
	
}
