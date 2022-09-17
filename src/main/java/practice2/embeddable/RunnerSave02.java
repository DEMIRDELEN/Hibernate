package practice2.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

	public static void main(String[] args) {
		
		Doctor02 dr1=new Doctor02(1001,"fatih polat",10,"fatih@email.com", "kbb");
		Doctor02 dr2=new Doctor02(1002,"enes pasa",10,"enes@email.com", "acil");
		Doctor02 dr3=new Doctor02(1003,"dr strange",10,"dr@email.com", "kalp");
		Doctor02 dr4=new Doctor02();
		
		dr4.setId(1004);
		dr4.setName("rick rich");
		dr4.setGrade(12);
		dr4.setBranch("genel cerrah");
		
		Education edu1=new Education();
		edu1.setUniversity("itu");
		edu1.setCity("istanbul");
		edu1.setCountry("turkiye");
		edu1.setDegree(99);
		
		dr1.setEducation(edu1);
		dr2.setEducation(edu1);
		dr3.setEducation(edu1);
		dr4.setEducation(edu1);
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor02.class);
		
		SessionFactory sf=con.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(dr1);
		session.save(dr2);
		session.save(dr3);
		session.save(dr4);
		
		tx.commit();
		session.close();
		sf.close();
		
		
	}

}
