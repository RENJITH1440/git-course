package com.blueAnt.SimpleAppServices.impl;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class commonSession {
	
	public Session session(Class className) {
		Configuration config = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL,"jdbc:mysql://localhost:3306/sys");
		properties.put(Environment.USER,"root");
		properties.put(Environment.PASS, "root@123");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		properties.put(Environment.SHOW_SQL,true);
		config.addAnnotatedClass(className);
		config.setProperties(properties);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(reg);
		Session session = factory.openSession();
		return session;
	}	

}
