package practice3.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

	public static void main(String[] args) {

		Doctor03 dr1 = new Doctor03();
		Stethoscope ste1 = new Stethoscope();

		dr1.setId(1001);
		dr1.setName("rick rich");
		dr1.setGrade(12);
		dr1.setBranch("genel cerrah");
		dr1.setEmail("email");
		dr1.setStethoscope(ste1);//bu satir inner join olusturur

		ste1.setId(101);
		ste1.setName(dr1.getName() + " 's stethoscope");
		ste1.setDoctor(dr1); //bu satir inner join olusturur
		
		Doctor03 dr2 = new Doctor03();
		Stethoscope ste2 = new Stethoscope();

		dr2.setId(1002);
		dr2.setName("kemal cek");
		dr2.setBranch("goz");
		dr2.setEmail("aeemail.com");
		dr2.setGrade(14);
		dr2.setStethoscope(ste2);

		ste2.setId(102);
		ste2.setName(dr2.getName() + " 's stethescope");
		ste2.setDoctor(dr2);

		Doctor03 dr3 = new Doctor03();

		dr3.setId(1003);
		dr3.setName("cihan set");
		dr3.setBranch("kalp");
		dr3.setEmail("aeaaemail.com");
		dr3.setGrade(15);
		
		Stethoscope ste3 = new Stethoscope();
		ste3.setId(103);
		ste3.setName("nobody's stet");
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor03.class)
				.addAnnotatedClass(Stethoscope.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dr1);
		session.save(dr2);
		session.save(dr3);
		session.save(ste1);
		session.save(ste2);
		session.save(ste3);
		
		tx.commit();
		session.close();
		sf.close();

	}
}
