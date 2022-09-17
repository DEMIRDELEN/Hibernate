package practice2.embeddable;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

	public static void main(String[] args) {
		
		Doctor02 dr10=new Doctor02();
		Doctor02 dr20=new Doctor02();
		Doctor02 dr30=new Doctor02();
		Doctor02 dr40=new Doctor02();
		
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor02.class);
		
		SessionFactory sf=con.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		//1001 id li  dr nin edu bilgilerini cekin
		
		
		
		tx.commit();
		session.close();
		sf.close();

	}

}
