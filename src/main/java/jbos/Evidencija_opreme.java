package jbos;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zakupljeno")
public class Evidencija_opreme implements Serializable {
	@Id
	@Column(name = "ID_oprema")
	private int idOprema;
	@Id
	@Column(name = "projekat_ID")
	private int idProj;
	@Column(name="brojElemenata")
	private int brEl;

	public Evidencija_opreme() {

	}

	public Evidencija_opreme(int IDOprema, int IDProjekta,int brEl) {
		this.idOprema = IDOprema;
		this.idProj = IDProjekta;
		this.brEl=brEl;
	}

	

	public int getIdOprema() {
		return idOprema;
	}

	public int getIdProj() {
		return idProj;
	}
	public int getBrEl() {
		return brEl;
	}
	public void setBrEl(int BrEl){
		this.brEl=BrEl;
	}

}
