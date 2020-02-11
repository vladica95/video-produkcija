package jbos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projekat")
public class Projekat implements Serializable {

	@Id
	@Column(name = "IDprojekat")
	private int id;
	@Column(name = "ime")
	private String ime;
	@Column(name = "cenaProjekta")
	private int cenaProjekta;
	@Column(name = "datumPocetak")
	private Date datumPoc;
	@Column(name = "datumKraj")
	private Date datumKraj;
	@Column(name = "ID_klijent")
	private int ID_Klijent;

	private ArrayList<Oprema> ListaOpreme = new ArrayList<Oprema>();
	private ArrayList<Zaposleni> ListaZaposlenih = new ArrayList<Zaposleni>();

	public Projekat() {

	}

	public Projekat(int ID, String Ime, int CENA, int IDK) {
		this.id = ID;
		this.ime = Ime;
		this.cenaProjekta = CENA;
		this.ID_Klijent = IDK;
	}

	public Projekat(String Ime, int CENA, int IDK) {
		this.ime = Ime;
		this.cenaProjekta = CENA;
		this.ID_Klijent = IDK;
	}

	public void dodajRadnika(Zaposleni z) {
		this.ListaZaposlenih.add(z);
	}

	public void dodajOpremu(Oprema o) {
		this.ListaOpreme.add(o);
	}

	public Oprema getOprema(int ID) {
		Oprema o = new Oprema();
		for (int i = 0; i < ListaOpreme.size(); i++) {
			Oprema pom = this.ListaOpreme.get(i);
			if (pom.getId() == ID) {
				o = pom;
			}
		}
		return o;
	}
	public Zaposleni getZaposleni(int ID){
		Zaposleni zap=new Zaposleni();
		for (int i = 0; i < ListaZaposlenih.size(); i++) {
			Zaposleni pom = this.ListaZaposlenih.get(i);
			if (pom.getId() == ID) {
				zap = pom;
			}
		}
		return zap;
	}

	public int getCena() {
		return cenaProjekta;
	}

	public void setCena(int CENA) {
		this.cenaProjekta = CENA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getIdKli() {
		return ID_Klijent;
	}

}
