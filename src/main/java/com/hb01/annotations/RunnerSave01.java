package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student01 student1 = new Student01();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(10);
		
		Student01 student2 = new Student01();
		student2.setId(1002);
		student2.setName("James bond");
		student2.setGrade(10);

		Student01 student3 = new Student01();
		student3.setId(1003);
		student3.setName("Tony Stark");
		student3.setGrade(11);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class).buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		tx.commit();

		session.close();

		sf.close();

	}

}
