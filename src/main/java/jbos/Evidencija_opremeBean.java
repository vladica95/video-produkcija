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

@Remote(Evidencija_opremeRemote.class)
@Stateless
public class Evidencija_opremeBean implements Evidencija_opremeRemote {
	EntityManager em;

	public Evidencija_opremeBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Override
	public void dodajOpremuNaProj(int IDOpr, int IDProj, int BrEl) {
		em.getTransaction().begin();
		Evidencija_opreme EO = new Evidencija_opreme(IDOpr, IDProj, BrEl);
		em.persist(EO);
		em.getTransaction().commit();

	}

	public Evidencija_opreme nadji(int IDOpr, int IDProj) {
		String query = "select e from zakupljno e where e.ID_oprema=" + IDOpr + "and e.projekat_ID=" + IDProj;
		List<Evidencija_opreme> EO = em.createQuery(query).getResultList();
		Evidencija_opreme zaRet = EO.get(0);
		return zaRet;
	}

	@Override
	public void azurirajOpremu(int IDopr, int IDProj, int newBrEl) {
		Evidencija_opreme EO = nadji(IDopr, IDProj);
		em.getTransaction().begin();
		EO.setBrEl(newBrEl);
		em.getTransaction().commit();

	}

	@Override
	public Evidencija_opreme delete(int IDopr, int IDProj) {
		Evidencija_opreme EO = nadji(IDopr, IDProj);
		em.getTransaction().begin();
		em.remove(EO);
		em.getTransaction().commit();

		return EO;
		
	}

	@Override
	public ArrayList<Evidencija_opreme> getOpremaiNaProj(int id) {
		String query = "select e from zakupljeno e where e.projekat_ID=" + id;
		List<Evidencija_opreme> ER = em.createQuery(query).getResultList();
		return (ArrayList<Evidencija_opreme>) ER;
	}

	@Override
	public ArrayList<Evidencija_opreme> getProjZaOpr(int id) {
		String query = "select e from zakupljeno e where e.ID_oprema=" + id;
		List<Evidencija_opreme> ER = em.createQuery(query).getResultList();
		return (ArrayList<Evidencija_opreme>) ER;
	}

	@Override
	public ArrayList<Evidencija_opreme> getAll() {
		List<Evidencija_opreme> ER = em.createQuery("SELECT e FROM zakupljeno e").getResultList();

		return (ArrayList<Evidencija_opreme>) ER;
	}

	@Override
	public void printAll() {
		List<Evidencija_opreme> ER  = this.getAll();
		for(int i = 0; i<ER.size(); i++) {
			Evidencija_opreme k1 = ER.get(i);
			System.out.println(k1.getIdOprema() + " " + k1.getIdProj());
		}

	}

}
