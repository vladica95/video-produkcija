package jbos;

import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

public interface OpremaRemote {

	public void dodajOpremu(String ime, int cena);

	public Oprema getOprema(int id);

	public Oprema deleteOprema(int id);

	public void azuzrirajOprema(int id, String newIme,int newCena);

	public ArrayList<Oprema> getAll();

	public void printAll();
}
