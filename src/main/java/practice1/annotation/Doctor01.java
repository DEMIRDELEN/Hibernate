package practice1.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;

@Entity 
@Table(name="tbl_doctor")
public class Doctor01 {
	//Bu annotationu koyduğumuz sınıf veritabanında bir tabloya karşılık gelecek
	//@Entity //@Entity tells to Hibernate to convert a class to a table
	//Eğer oluşacak tablo ismini değiştirmek istenirse name attribute 
	//ile bir tablo ismi verilir.
	
	/* Not: Veritabanında tablo oluşturmak için hibernate'de bir sınıf
	 *  kullanacaksanız,
	 *  "final" veya "static" değişkenleri yapmayın */
	/*
	POJO: Plain Old Java Object
	1)Create private variables
	2)Create constructor
	3)Create getters and setters
	4)Create toString()
	*/
	@Id//@Id is used to make a variable primary key in table
	private int id;
	
	@Column(name="doctor_name",length=100, nullable=false,unique=false)
	//@Column() is used to be able to use different names for columns
	private String name;
	
	@Column(name="doctor_grade")
	private int grade;
	
	@Transient // @Transient is used not to make a variable column
	private String email;
	
	@Column(name="doctor_branch")
	private String branch;

	
	
	public Doctor01(int id, String name, int grade, String email, String branch) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.email = email;
		this.branch = branch;
	}

	public Doctor01() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Doctor01 [id=" + id + ", name=" + name + ", grade=" + grade + ", email=" + email + ", branch=" + branch
				+ "]";
	}
	
	
	
	
	
}
