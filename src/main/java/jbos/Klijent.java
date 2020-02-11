package jbos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "klijent")
public class Klijent implements Serializable {

	@Id
	@Column(name = "idklijent")
	private int id;
	@Column(name = "ime")
	private String ime;
	@Column(name = "prezime")
	private String prezime;
	@Column(name = "datum_rodj")
	private Date datum_rodj;
	@Column(name = "jmbg")
	private int jmbg;
	@Column(name = "adresa")
	private String adresa;
	@Column(name = "pol")
	private char pol;

	public Klijent() {

	}

	public Klijent(int id, String ime, String prez, Date datumRodj, int JMBG, String adresa, char pol) {
		this.id = id;
		this.ime = ime;
		this.prezime = prez;
		this.datum_rodj = datumRodj;
		this.jmbg = JMBG;
		this.adresa = adresa;
		this.pol = pol;
	}

	public Klijent(String ime, String prez, Date datumRodj, int JMBG, String adresa, char pol) {

		this.ime = ime;
		this.prezime = prez;
		this.datum_rodj = datumRodj;
		this.jmbg = JMBG;
		this.adresa = adresa;
		this.pol = pol;
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

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDR() {
		return datum_rodj;
	}

	public void setDR(Date DR) {
		this.datum_rodj = DR;
	}

	public int getJMBG() {
		return jmbg;
	}

	public void setJMBG(int JMBG) {
		this.jmbg = JMBG;
	}

	public String getAdr() {
		return adresa;
	}

	public void setAdr(String ADRESA) {
		this.adresa = ADRESA;
	}

	public char getPol() {
		return pol;
	}

	public void setPol(char POL) {
		this.pol = POL;
	}

}