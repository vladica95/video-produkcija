package jbos;

import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

public interface ZaposleniRemote {

	public void dodajZaposlenog(String ime, String prez, char pol, String adresa, Date datumRodj, int JMBG, int plata,
			String uloga);

	public Zaposleni getZaposleni(int id);

	public Zaposleni deleteZaposleni(int id);

	public void azuzrirajZaposleni(int id, String newIme, String newPrezime, String newAdresa,int newPlata,String newUloga);

	public ArrayList<Zaposleni> getAll();

	public void printAll();

}