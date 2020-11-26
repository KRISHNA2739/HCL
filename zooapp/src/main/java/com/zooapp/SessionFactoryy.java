package com.zooapp;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryy {
	
	private static org.hibernate.SessionFactory  sessionFactory = null;
	public static org.hibernate.SessionFactory getConnection() {
		
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		sessionFactory=new MetadataSources(serviceRegistry)
				.buildMetadata().buildSessionFactory();
		
		return  sessionFactory;
	}

}
