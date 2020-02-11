package jbos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Remote(klijentRemote.class)
@Stateless
public class klijentBean implements klijentRemote {

	EntityManager em;

	public klijentBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	public void dodajKlijenta(String ime, String prez, Date datumRodj, int JMBG, String adresa, char pol) {
		em.getTransaction().begin();
		Klijent k1 = new Klijent(ime,prez, datumRodj, JMBG, adresa, pol);
		em.persist(k1);
		em.getTransaction().commit();

	}

	public Klijent getKlijent(int id) {
		Klijent k = em.find(Klijent.class, id);

		return k;
	}
	public Klijent deleteKlijent(int id) {
		Klijent klio = em.find(Klijent.class, id);
		em.getTransaction().begin();
		em.remove(klio);
		em.getTransaction().commit();

		return klio;
	}

	public void azuzrirajKlijenta(int id, String newIme, String newPrezime, String newAdresa) {
		Klijent klio = em.find(Klijent.class, id);
		em.getTransaction().begin();		
		klio.setIme(newIme);
		klio.setPrezime(newPrezime);
		klio.setAdr(newAdresa);
		em.getTransaction().commit();

	}

	public ArrayList<Klijent> getAll() {
		List<Klijent> klijenti = em.createQuery("SELECT k FROM klijent k").getResultList();

		return (ArrayList<Klijent>) klijenti;
	}

	public void printAll() {
		List<Klijent> klijenti = this.getAll();
		for(int i = 0; i<klijenti.size(); i++) {
			Klijent k1 = klijenti.get(i);
			System.out.println(k1.getId() + " " + k1.getIme());
		}

	}
}
