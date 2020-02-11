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

@Remote(EvidencijaRadnikaRemote.class)
@Stateless
public class EvidencijaRadnikaBean implements EvidencijaRadnikaRemote {

	EntityManager em;

	public EvidencijaRadnikaBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Override
	public void dodajZaposlenogNaProj(int IDZap, int IDProj) {
		em.getTransaction().begin();
		Evidencija_radnika k1 = new Evidencija_radnika(IDZap, IDProj);
		em.persist(k1);
		em.getTransaction().commit();

	}

	@Override
	public ArrayList<Evidencija_radnika> getZaposleniNaProj(int id) {
		String query = "select e from radi_na e where e.ID_projekat=" + id;
		List<Evidencija_radnika> ER = em.createQuery(query).getResultList();
		return (ArrayList<Evidencija_radnika>) ER;
	}

	@Override
	public ArrayList<Evidencija_radnika> getProjZaZap(int id) {
		String query = "select e from radi_na e where e.ID_zaposleni=" + id;
		List<Evidencija_radnika> ER = em.createQuery(query).getResultList();
		return (ArrayList<Evidencija_radnika>) ER;
	}

	@Override
	public ArrayList<Evidencija_radnika> getAll() {
		List<Evidencija_radnika> ER = em.createQuery("SELECT e FROM radi_na e").getResultList();

		return (ArrayList<Evidencija_radnika>) ER;
	}

	@Override
	public void printAll() {
		List<Evidencija_radnika> ER  = this.getAll();
		for(int i = 0; i<ER.size(); i++) {
			Evidencija_radnika k1 = ER.get(i);
			System.out.println(k1.getIdZap() + " " + k1.getIdProj());
		}

	}

	@Override
	public Evidencija_radnika delete(int IDZap, int IDProj) {
		String query = "select e from radi_na e where e.ID_zaposleni=" + IDZap + "and e.ID_projekat=" + IDProj;
		List<Evidencija_radnika> ER = em.createQuery(query).getResultList();
		Evidencija_radnika zaDel = ER.get(0);
		em.getTransaction().begin();
		em.remove(zaDel);
		em.getTransaction().commit();

		return zaDel;
	}
	
	

}
