package jbos;


import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

public interface Evidencija_opremeRemote {

	public void dodajOpremuNaProj(int IDOpr,int IDProj,int BrEl);
	
	public void azurirajOpremu(int IDopr,int IDProj,int newBrEl);
	
	public Evidencija_opreme delete(int IDopr,int IDProj);

	public ArrayList<Evidencija_opreme> getOpremaiNaProj(int id);

	public ArrayList<Evidencija_opreme> getProjZaOpr(int id);
	
	public ArrayList<Evidencija_opreme> getAll();

	public void printAll();
}
