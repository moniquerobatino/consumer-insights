package br.com.fiap.enjoyit.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("enjoyit");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();	
	}

}