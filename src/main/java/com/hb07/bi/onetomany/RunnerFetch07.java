package com.hb07.bi.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
		
		SessionFactory sf= con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx = session.beginTransaction();
         
	   // Student07 student= session.get(Student07.class, 1001);
		
	    //student.getBookList().forEach(System.out::println);
	    //student.getBookList().forEach(b->System.out.println(b));
		
		// SQL query öğrencinin bilgilerini getirelim
//	    String sqlQuery1="SELECT s.student_name,b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
//	    List<Object[]> resultList1= session.createSQLQuery(sqlQuery1).getResultList();
//		
//	    for (Object[] objects : resultList1) {
//			System.out.println(Arrays.toString(objects));
//		}
	    
//		String hqlQuery1="SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student.id";
//		List<Object[]> resultList2= session.createQuery(hqlQuery1).getResultList();
//		resultList2.forEach(oa->System.out.println(Arrays.toString(oa)));
		
//		
//		String sqlQuery2="DELETE FROM book07";
//		int numOfRec= session.createSQLQuery(sqlQuery2).executeUpdate();
//		System.out.println("Effected Row count:"+numOfRec);
//		
//		String sqlQuery3="DELETE FROM Student07";
//		int numOfRec2= session.createSQLQuery(sqlQuery3).executeUpdate();
//		System.out.println("Effected Row count:"+numOfRec2);
		
		
//		String hqlQuery1="DELETE FROM Book07";
//		int numOfRec3= session.createQuery(hqlQuery1).executeUpdate();
//		System.out.println("Effected Row count:"+numOfRec3);
//		
//		String hqlQuery2="DELETE FROM Student07";
//		int numOfRec4= session.createQuery(hqlQuery2).executeUpdate();
//		System.out.println("Effected Row count:"+numOfRec4);
		
	
		
		
		tx.commit();
		session.close();
        sf.close();
	}

}