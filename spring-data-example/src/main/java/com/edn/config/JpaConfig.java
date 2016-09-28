package com.edn.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
	
	@Bean
	public DataSource dataSource() {
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase database = builder.setType(EmbeddedDatabaseType.HSQL).build();
		
		return database;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.HSQL);
		adapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(adapter);
		factory.setPackagesToScan("com.edn.model");
		factory.setDataSource(dataSource());
		
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return txManager;
	}
	
	@Bean
	@Lazy(false)
	public ResourceDatabasePopulator populateDatabase() throws SQLException {
		
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("data.sql"));
		
		Connection con = null;
		
		try {
			con = DataSourceUtils.getConnection(dataSource());
			populator.populate(con);
		} finally {
			if(con != null)
				DataSourceUtils.releaseConnection(con, dataSource());
		}
		
		return populator;
	}
	
}
