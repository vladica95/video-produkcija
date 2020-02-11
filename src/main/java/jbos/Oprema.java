package jbos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oprema")
public class Oprema implements Serializable {

	@Id
	@Column(name = "IDoprema")
	private int id;
	@Column(name = "ime")
	private String ime;
	@Column(name = "cena")
	private int cena;

	public Oprema() {
	}

	public Oprema(int id, String ime, int cena) {
		this.id = id;
		this.ime = ime;
		this.cena = cena;
	}

	public Oprema(String ime, int cena) {
		this.ime = ime;
		this.cena = cena;
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

	public int getCena() {
		return cena;
	}

	public void setCena(int CENA) {
		this.cena = CENA;
	}

}
