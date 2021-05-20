package com.samaspace.clientdao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.samaspace.JPAutil.JPAutil;
import com.samaspace.entities.Client;

public class ClientManager {
	
	private static EntityManager em = JPAutil.getEntityManager("UnitClient");
	
	
	
	
	
	public static void ajouterClient(Client c) {
		
		EntityTransaction et = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			em.persist(c);
			et.commit();
			System.out.println("Bien ajouté " +c.getNom());
			
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
			
		} finally {
			em.close();
		}
		 
		
	}
	
	public static void modifierClient(Client C) {
		
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			em.merge(C);
			
			et.commit();
			
			
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
public static void modifierClientV2(int id, String fn, String ville) {
		
		EntityTransaction et = null;
		Client client = null;
		try {
			
			et = em.getTransaction();
			et.begin();
			
			client = em.find(Client.class, id);
			client.setNom(fn);
			client.setVille(ville);
			
			em.persist(client);
			et.commit();
			
			
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static void supprimerClient(Client c) {
		
		EntityTransaction et = null;
		try {
			
			et = em.getTransaction();
			et.begin();
			
			
			c = em.merge(c);
			em.remove(c);
			et.commit(); 
			
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
public static void supprimerClientV2(int id) {
		
		EntityTransaction et = null;
		Client c = null;
		try {
			
			et = em.getTransaction();
			et.begin();
			
			c = em.find(Client.class, id);
			
			em.remove(c);
			et.commit();
			
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	public static Client consulter(Client c, Object id) {
		
		return em.find(c.getClass(), id);
		
	}
	
	
	
	public static void ListerTous() {
		
		String query = "select c FROM Client c where c.id is not null";
		TypedQuery<Client> tq = em.createQuery(query, Client.class);
		List<Client> clients;
		
		try {
			
			clients = tq.getResultList();
			clients.forEach(clt->System.out.println(clt.getNom() + " " + clt.getVille()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
		
	}
	
	
public static void ListerByName(String nom) {
		
		String query = "select c FROM Client c where c.nom LIKE :nom";
		TypedQuery<Client> tq = em.createQuery(query, Client.class);
		tq.setParameter("nom", "%"+nom+"%");
		List<Client> clients;
		
		try {
			
			clients = tq.getResultList();
			System.out.println("******* clients *********");
			clients.forEach(clt->System.out.println(clt.getNom() + " " + clt.getVille()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
		
	}

	public static void closeEntity() {
    	em.close();
    }

}
