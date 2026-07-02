package com.sample.Config;
import java.util.Properties;

import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.orm.jpa.hibernate.*;
//import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
//import org.springframework.orm.hibernate.HibernateTransactionManager;

@Configuration
@ComponentScan("com.sample")
@EnableTransactionManagement
public class AppConfig {
    @Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springormDB");
		ds.setUsername("root");
		ds.setPassword("Shahistha@2005");
		return ds;
		
	}
    @Bean
    public LocalSessionFactoryBean getSessionFcatory() {
    	LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
         factory.setDataSource(getDataSource());
         factory.setPackagesToScan("com.sample.Models");
         Properties pr=new Properties();
         pr.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
         pr.put("hibernate.show.sql", "true");
         pr.put("hibernate.hbm2ddl.auto", "update");
         
         factory.setHibernateProperties(pr);
         return factory;
        
    	}
    @Bean
    public HibernateTransactionManager getTransManager(SessionFactory sf) {
    	return new HibernateTransactionManager(sf);
    }
}
