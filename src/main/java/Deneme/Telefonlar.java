package Deneme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefonlar {

	@Id
	@Column(name = "TELEFON_ID")
	private int id;

	@Column(name = "Numara")
	private String numara;

	@Column(name = "Telekom")
	private String telekom;
	
	@ManyToOne
	private Uye uye;
	

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getNumara() {
		return numara;
	}

	public void setNumara(String numara) {
		this.numara = numara;
	}

	public String getTelekom() {
		return telekom;
	}

	public void setTelekom(String telekom) {
		this.telekom = telekom;
	}

	public Uye getUye() {
		return uye;
	}

	public void setUye(Uye uye) {
		this.uye = uye;
	}

	@Override
	public String toString() {
		return "Telefonlar [id=" + id + ", numara=" + numara + ", telekom=" + telekom + ", uye=" + uye + "]";
	}

	

	// Getter Setter
	
}
