package com.samaspace.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
	
	
	private static EntityManagerFactory factory;
	private static EntityManager EM;
	
	public static EntityManager getEntityManager(String PersisUnit) {

		if(EM == null) {
			
		factory = Persistence.createEntityManagerFactory("UnitClient");
		//factory = Persistence.createEntityManagerFactory(PersisUnit);
		EM = factory.createEntityManager();
		
		}
		
		return EM;
	}

}
