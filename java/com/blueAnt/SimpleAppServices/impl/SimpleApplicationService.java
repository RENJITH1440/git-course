package com.blueAnt.SimpleAppServices.impl;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.blueAnt.SimpleAppServices.ISimpleApplicationService;
import com.blueAnt.domain.Vendors;

@Service(value="simpleapplicationservice")
public class SimpleApplicationService implements ISimpleApplicationService{

	String url="jdbc:mysql://localhost:3306/sys";
	String username = "root";
	String password = "root@123";
	
	@Override
	public JdbcTemplate fetchTemplate() {
		
	return new JdbcTemplate(new DriverManagerDataSource(url,username,password));
	}

	@Override
	public Session session() {
		Configuration config = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL,"jdbc:mysql://localhost:3306/sys");
		properties.put(Environment.USER,"root");
		properties.put(Environment.PASS, "root@123");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		properties.put(Environment.SHOW_SQL,true);
		config.addAnnotatedClass(Vendors.class);
		config.setProperties(properties);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(reg);
		Session session = factory.openSession();
		return session;
	}
	
	

}
