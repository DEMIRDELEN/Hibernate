package practice1.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

	public static void main(String[] args) {
		
		Doctor01 dr1=new Doctor01(1001,"fatih polat",10,"fatih@email.com", "kbb");
		Doctor01 dr2=new Doctor01(1002,"enes pasa",10,"enes@email.com", "acil");
		Doctor01 dr3=new Doctor01(1003,"dr strange",10,"dr@email.com", "kalp");
		Doctor01 dr4=new Doctor01();
		dr4.setId(1004);
		dr4.setName("rick rich");
		dr4.setGrade(12);
		dr4.setBranch("genel cerrah");
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor01.class);
		
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
