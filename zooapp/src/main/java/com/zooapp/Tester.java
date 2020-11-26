package com.zooapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Tester {
	
	public static void main(String[] args) {
		
		SessionFactory factory=SessionFactoryy.getConnection();
        Session session = factory.openSession();
	}

}
