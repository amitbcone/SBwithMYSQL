package com.amit.sbmysql.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="com.amit.sbmysql.repositories", 
transactionManagerRef = "jpaTransactionManager")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DSConfig {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDS() {
		return DataSourceBuilder.create().username(env.getProperty("spring.datasource.username"))
				.password(env.getProperty("spring.datasource.password"))
				.url(env.getProperty("spring.datasource.url"))
				.driverClassName(env.getProperty("spring.datasource.driver-class-name")).build();
	}
	
	@Bean (name="jpaTransactionManager")
	public JpaTransactionManager getTM() {
		JpaTransactionManager tm= new JpaTransactionManager();
		tm.setEntityManagerFactory(getemf().getObject());
		return tm;
	}
	
	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		return vendorAdapter;
	}

	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getemf() {
		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		emfBean.setJpaVendorAdapter(vendorAdaptor());
		emfBean.setDataSource(getDS());
		emfBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emfBean.setPackagesToScan("com.amit.sbmysql.entities");
		emfBean.setJpaProperties(addProperties());
		return emfBean;
	}

	private Properties addProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		return properties;
	}
	
}
