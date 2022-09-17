package Deneme;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class Uye {
	
	 @Id
	 @Column(name = "UYE_ID")
	 private int id;
	 
	 @Column(name = "Adi")
	 private String adi;
	 
	 @OneToMany(mappedBy="Uye")
	 private List<Telefonlar> Telefonlar = new ArrayList<Telefonlar>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}
	
	public List<Telefonlar> getTelefonlar() {
		return Telefonlar;
	}

	public void setTelefonlar(List<Telefonlar> Telefonlar) {
		this.Telefonlar = Telefonlar;
	}

	@Override
	public String toString() {
		return "Uye [id=" + id + ", adi=" + adi + ", Telefonlar=" + Telefonlar + "]";
	}
	 

	 //Getter Setter
	}

