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

@Remote(ProjekatRemote.class)
@Stateless

public class ProjekatBean implements ProjekatRemote {

	EntityManager em;

	public ProjekatBean() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU");
		em = emf.createEntityManager();
	}

	@Override
	public void dodajProjekat(String ime, int IDK) {
		em.getTransaction().begin();
		Projekat proj = new Projekat(ime, 0, IDK);
		em.persist(proj);
		em.getTransaction().commit();

	}

	@Override
	public void zaposliRadnika(int ID, int IDProj) {
		EvidencijaRadnikaBean er = new EvidencijaRadnikaBean();
		er.dodajZaposlenogNaProj(ID, IDProj);
		AzurirajCenuProj(IDProj);

	}

	@Override
	public void otpustiRadnika(int ID, int IDProj) {
		EvidencijaRadnikaBean er = new EvidencijaRadnikaBean();
		er.delete(ID, IDProj);
		AzurirajCenuProj(IDProj);

	}

	@Override
	public void zakupiOpremu(int ID, int IDProj, int BrojEl) {
		Evidencija_opremeBean er = new Evidencija_opremeBean();
		er.dodajOpremuNaProj(ID, IDProj, BrojEl);
		AzurirajCenuProj(IDProj);

	}
	@Override
	public void dodajcenuUsluge(int ID , int cenaUSL){
		AzurirajCenuProj(ID);
		Projekat op = em.find(Projekat.class, ID);
		em.getTransaction().begin();
		int newCena=op.getCena()+cenaUSL;
		op.setCena(newCena);
		em.getTransaction().commit();
		
	}

	@Override
	public void vratiOpremuProd(int ID, int IDProj) {
		Evidencija_opremeBean er = new Evidencija_opremeBean();
		er.delete(ID, IDProj);
		AzurirajCenuProj(IDProj);

	}

	@Override
	public Projekat getProjekat(int id) {
		Projekat op = em.find(Projekat.class, id);

		return op;
	}

	@Override
	public Projekat deleteProjekat(int id) {
		Projekat op = em.find(Projekat.class, id);
		em.getTransaction().begin();
		em.remove(op);
		em.getTransaction().commit();

		return op;
	}

	@Override
	public void AzurirajCenuProj(int ID) {
		ZaposleniBean rb = new ZaposleniBean();
		OpremaBean ob = new OpremaBean();
		int newCena = 0;
		Projekat op = em.find(Projekat.class, ID);
		em.getTransaction().begin();
		EvidencijaRadnikaBean erb = new EvidencijaRadnikaBean();
		ArrayList<Evidencija_radnika> listaRnaP = erb.getZaposleniNaProj(ID);
		for (int i = 0; i < listaRnaP.size(); i++) {
			Evidencija_radnika er = listaRnaP.get(i);
			Zaposleni novko = rb.getZaposleni(er.getIdZap());
			newCena = newCena + novko.getPlata();
		}

		Evidencija_opremeBean eob = new Evidencija_opremeBean();
		ArrayList<Evidencija_opreme> listaOPnaP = eob.getOpremaiNaProj(ID);
		for (int i = 0; i < listaOPnaP.size(); i++) {
			Evidencija_opreme eo = listaOPnaP.get(i);
			Oprema opremko = ob.getOprema(eo.getIdOprema());
			newCena = newCena + (opremko.getCena() * eo.getBrEl());
		}

		op.setCena(newCena);

		em.getTransaction().commit();

	}

	@Override
	public void azuzrirajProjekat(int id, String newIme) {
		Projekat op = em.find(Projekat.class, id);
		em.getTransaction().begin();
		op.setIme(newIme);
		em.getTransaction().commit();
		AzurirajCenuProj(id);
	}

	@Override
	public ArrayList<Projekat> getAll() {
		List<Projekat> proj = em.createQuery("SELECT p FROM projekat p").getResultList();

		return (ArrayList<Projekat>) proj;
	}

	@Override
	public void printAll() {
		List<Projekat> proj = this.getAll();
		for (int i = 0; i < proj.size(); i++) {
			Projekat op = proj.get(i);
			System.out.println(
					op.getId() + " " + op.getIme() + " " + op.getCena() + " " + "ID klijenta  " + op.getIdKli());
		}

	}

}
