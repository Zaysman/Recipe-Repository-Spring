package com.isaiah.objects.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateClient {

	private static org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration().addPackage("com.isaiah.objects").configure(); //I believe this has something to do with the Hibernate annotations
	private static StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	private static Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	private static SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	
}
