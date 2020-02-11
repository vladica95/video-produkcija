package jbos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "radi_na")
public class Evidencija_radnika implements Serializable {
	@Id
	@Column(name = "ID_zaposleni")
	private int idZap;
	@Id
	@Column(name = "ID_projekat")
	private int idProj;

	public Evidencija_radnika() {

	}

	public Evidencija_radnika(int IDZaposlenog, int IDProjekta) {
		this.idZap = IDZaposlenog;
		this.idProj = IDProjekta;
	}


	public int getIdZap() {
		return idZap;
	}

	public int getIdProj() {
		return idProj;
	}

}
