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

@Remote(OpremaRemote.class)
@Stateless
public class OpremaBean implements OpremaRemote {

	EntityManager em;

	public OpremaBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Override
	public void dodajOpremu(String ime, int cena) {
		em.getTransaction().begin();
		Oprema op = new Oprema(ime, cena);
		em.persist(op);
		em.getTransaction().commit();

	}

	@Override
	public Oprema getOprema(int id) {
		Oprema op = em.find(Oprema.class, id);

		return op;
	}

	@Override
	public Oprema deleteOprema(int id) {
		Oprema op = em.find(Oprema.class, id);
		em.getTransaction().begin();
		em.remove(op);
		em.getTransaction().commit();

		return op;
	}

	@Override
	public void azuzrirajOprema(int id, String newIme, int newCena) {
		Oprema op = em.find(Oprema.class, id);
		em.getTransaction().begin();
		op.setIme(newIme);
		op.setCena(newCena);

		em.getTransaction().commit();

	}

	@Override
	public ArrayList<Oprema> getAll() {
		List<Oprema> oprema = em.createQuery("SELECT o FROM oprema o").getResultList();

		return (ArrayList<Oprema>) oprema;
	}

	@Override
	public void printAll() {
		List<Oprema> oprema = this.getAll();
		for (int i = 0; i < oprema.size(); i++) {
			Oprema op = oprema.get(i);
			System.out.println(op.getId() + " " + op.getIme() + " " + op.getCena());
		}

	}

}
