package jbos;

import java.sql.Date;
import java.util.ArrayList;
import javax.ejb.Remote;

public interface ProjekatRemote {

	public void dodajProjekat(String ime, int IDK);
	
	public void dodajcenuUsluge(int ID , int cenaUSL);
	
	public void AzurirajCenuProj(int ID);

	public void zaposliRadnika(int ID,int IDpr);
	
	public void otpustiRadnika(int ID,int IDproj);
	
	public void zakupiOpremu(int ID,int IDproj,int BrEl);
	
	public void vratiOpremuProd(int ID,int IDproj );
	
	public Projekat getProjekat(int id);

	public Projekat deleteProjekat(int id);

	public void azuzrirajProjekat(int id, String newIme);

	public ArrayList<Projekat> getAll();

	public void printAll();

}
