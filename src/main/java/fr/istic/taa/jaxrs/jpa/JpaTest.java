package fr.istic.taa.jaxrs.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dao.generic.*;


public class JpaTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDAO u = new UserDAO();
		ProfessionnelDAO p = new ProfessionnelDAO();
		RendezVousDAO r = new RendezVousDAO();
		try {
			//u.createUser();
			//p.createProfessionnel();
			u.showUser(u.getUserByMail("thomas.g@etudiant.univ-rennes1.fr"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		u.getUserRendezVous("thomas.g@etudiant.univ-rennes1.fr");
		//r.createRDV(u.getUserByMail("thomas.g@etudiant.univ-rennes1.fr"), p.getProfessionnelByMail("ax@gmail.com").get(0));
		System.out.println(u.showUser(u.getUserByMail("thomas.g@etudiant.univ-rennes1.fr")));
		System.out.println(u.showAllUser(u.getAllUser()));
	
	}

}
