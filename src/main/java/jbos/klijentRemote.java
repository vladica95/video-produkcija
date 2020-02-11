package jbos;

import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

public interface klijentRemote {

	public void dodajKlijenta(String ime, String prez, Date datumRodj, int JMBG, String adresa, char pol);

	public Klijent getKlijent(int id);

	public Klijent deleteKlijent(int id);

	public void azuzrirajKlijenta(int id, String newIme, String newPrezime, String newAdresa);

	public ArrayList<Klijent> getAll();

	public void printAll();
}
