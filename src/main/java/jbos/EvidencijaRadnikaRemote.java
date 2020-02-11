package jbos;

import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

public interface EvidencijaRadnikaRemote {

	public void dodajZaposlenogNaProj(int IDZap,int IDProj);
	
	public Evidencija_radnika delete(int IDZap,int IDProj);

	public ArrayList<Evidencija_radnika> getZaposleniNaProj(int id);

	public ArrayList<Evidencija_radnika> getProjZaZap(int id);
	
	public ArrayList<Evidencija_radnika> getAll();

	public void printAll();
	
}
