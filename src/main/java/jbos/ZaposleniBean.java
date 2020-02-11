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

@Remote(ZaposleniRemote.class)
@Stateless
public class ZaposleniBean implements ZaposleniRemote {

	EntityManager em;

	public ZaposleniBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Override
	public void dodajZaposlenog(String ime, String prez, char pol, String adresa, Date datumRodj, int JMBG, int plata,
			String uloga) {
		em.getTransaction().begin();
		Zaposleni z1 = new Zaposleni(ime, prez, pol, adresa, datumRodj, JMBG, plata, uloga);
		em.persist(z1);
		em.getTransaction().commit();
	}

	@Override
	public Zaposleni getZaposleni(int id) {
		Zaposleni k = em.find(Zaposleni.class, id);

		return k;
	}

	@Override
	public Zaposleni deleteZaposleni(int id) {
		Zaposleni zap = em.find(Zaposleni.class, id);
		em.getTransaction().begin();
		em.remove(zap);
		em.getTransaction().commit();

		return zap;
	}

	@Override
	public void azuzrirajZaposleni(int id, String newIme, String newPrezime, String newAdresa, int newPlata,
			String newUloga) {
		Zaposleni zap = em.find(Zaposleni.class, id);
		em.getTransaction().begin();
		zap.setIme(newIme);
		zap.setPrezime(newPrezime);
		zap.setAdr(newAdresa);
		zap.setPlata(newPlata);
		zap.setUloga(newUloga);
		em.getTransaction().commit();

	}

	@Override
	public ArrayList<Zaposleni> getAll() {
		List<Zaposleni> radnici = em.createQuery("SELECT z FROM zaposleni z").getResultList();

		return (ArrayList<Zaposleni>) radnici;
	}

	@Override
	public void printAll() {
		List<Zaposleni> radnici = this.getAll();
		for (int i = 0; i < radnici.size(); i++) {
			Zaposleni rad1 = radnici.get(i);
			System.out.println(rad1.getId() + " " + rad1.getIme() + " " + rad1.getPrezime() + " " + rad1.getUloga());
		}
	}

}
