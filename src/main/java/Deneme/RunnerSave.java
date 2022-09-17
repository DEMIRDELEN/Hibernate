package Deneme;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
	public static void main(String[] args) {

	
		Telefonlar telefon1 = new Telefonlar();
		telefon1.setId(1);
		telefon1.setNumara("501");
		telefon1.setTelekom("avea");

		Telefonlar telefon2 = new Telefonlar();
		telefon2.setId(2);
		telefon2.setNumara("502");
		telefon2.setTelekom("vodafone");

		Telefonlar telefon3 = new Telefonlar();
		telefon3.setId(3);
		telefon3.setNumara("503");
		telefon3.setTelekom("turkcell");
		
		Uye uye1 = new Uye();
		uye1.setAdi("ali");
		uye1.setId(1);
		uye1.getTelefonlar().add(telefon1);

		Uye uye2 = new Uye();
		uye2.setAdi("veli");
		uye2.setId(2);
		uye2.getTelefonlar().add(telefon2);

		Uye uye3 = new Uye();
		uye3.setAdi("can");
		uye3.setId(3);
		uye3.getTelefonlar().add(telefon3);

		
		

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Telefonlar.class)
				.addAnnotatedClass(Uye.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(uye1);
		session.save(uye2);
		session.save(uye3);

		session.save(telefon1);
		session.save(telefon2);
		session.save(telefon3);

		tx.commit();
		session.close();
		sf.close();

	}
}
