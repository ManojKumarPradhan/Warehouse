package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Customer;
import com.app.model.OrderMethod;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.Vendor;
import com.app.model.WhUserType;

@Configuration
@ComponentScan(basePackages = "com.app")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	private Environment env;

	// datasource
	@Bean
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("dc"));
		basicDataSource.setUrl(env.getProperty("url"));
		basicDataSource.setUsername(env.getProperty("un"));
		basicDataSource.setPassword(env.getProperty("pwd"));

		basicDataSource.setInitialSize(3);
		basicDataSource.setMaxIdle(2);
		basicDataSource.setMinIdle(2);
		basicDataSource.setMaxTotal(3);
		return basicDataSource;
	}

	// sessionfactory
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		bean.setAnnotatedClasses(Uom.class, OrderMethod.class, ShipmentType.class, WhUserType.class, Vendor.class,
				Customer.class);
		bean.setHibernateProperties(props());
		return bean;
	}

	private Properties props() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("dialect"));
		properties.put("hibernate.show_sql", env.getProperty("showsql"));
		properties.put("hibernate.format_sql", env.getProperty("fmtsql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return properties;
	}

	// hibernate template
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		return new HibernateTemplate(getSessionFactory().getObject());
	}

	// hibernate management
	@Bean
	public HibernateTransactionManager getTxManager() {
		return new HibernateTransactionManager(getSessionFactory().getObject());
	}

	// resolver
	@Bean
	public InternalResourceViewResolver getResolver() {
		return new InternalResourceViewResolver(env.getProperty("mvc.prefix"), env.getProperty("mvc.suffix"));
	}
}
