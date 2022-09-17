package practice3.onetoone;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch03 {

	public static void main(String[] args) {

		

		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Doctor03.class).addAnnotatedClass(Stethoscope.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// 1) id 1001 olan dr u fetch ediniz get methodu kullanarak
//		Doctor03 dr1=session.get(Doctor03.class, 1001);
//		System.out.println(dr1);
//		System.err.println("************");
	
		//2) id 101 olan stettoskpu fetch ediniz get methodu kullanarak
//		Stethoscope st1=session.get(Stethoscope.class, 101);
//		System.out.println(st1);
	
		//3) steteskoplu dr lari getiren hql sorgusu yaziniz
//		String hqlQuery1="select d.name, s.name from Doctor03 d "
//				+ "inner join fetch Stethoscope s on d.id=s.doctor";
//		List<Object[]> resultList1= session.createQuery(hqlQuery1).getResultList();
//		for (Object[] w : resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//4) steteskoplu dr lari getiren sql sorgusu yaziniz

		
		
		//5) Fetch doctor name, stet name and doctor grade of records from Doctor table
		//steteskoplu ve steteskopsuz dr lari getir
//		String sqlQuery1="select d.doctor_name, s.name, d.doctor_grade from tbl_doctor d"
//				+ " left join tbl_stethoscope s on d.id=s.dr_id";  
//		List<Object[]> resultList1=session.createNativeQuery(sqlQuery1).getResultList();
//		for (Object[] w : resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		
		
		//hql ile

		
		
		//6) fetch doctor name, stet name and doctor grade of records from Stethoscope table
		//stethescope table indan hepsini getir doktoru olan olmayan tum stethescope lar
//		String sqlQuery1="select d.doctor_name, s.name, d.doctor_grade from tbl_doctor d"
//				+ " RIGHT join tbl_stethoscope s on d.id=s.dr_id";  
//		List<Object[]> resultList1=session.createNativeQuery(sqlQuery1).getResultList();
//		for (Object[] w : resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//hql ile

		
		
		//7) Fetch doctor name, stet name and dr grade of all records from Doctor03 and 
		//Stethoscope table
//			String sqlQuery="select d.doctor_name, s.name,d.doctor_grade from tbl_stethoscope s "
//					+ "full join tbl_doctor d  on d.id=s.dr_id";
//			List<Object[]> resultList1=session.createSQLQuery(sqlQuery).getResultList();
//			for (Object[] w : resultList1) {
//				System.out.println(Arrays.toString(w));
//				[rick rich, rick rich 's stethoscope, 12]  INNER JOIN
//				 [kemal cek, kemal cek 's stethescope, 14] INNER JOIN
//				 [null, nobody's stet, null]               RIGHT JOIN
//				 [cihan set, null, 15]						LEFT JOIN	
				//NATIVEQUERY DE SQLQUERY NIN AYNI ISLEVINI GORUR
			//}
		
		//hql ile

		

        //8) Fetch all doctors information of common records from doctor and stethoscope table
				//STETHOSCOPE U OLAN DR LARI GETIR
		
		//hql ile
//			String hqlQuery="from Doctor03 d inner join fetch Stethoscope s on d.id=s.doctor";
//			List<Object[]> resultList=session.createQuery(hqlQuery).getResultList();
//			for (Object[] w : resultList) {
//				System.out.println(Arrays.toString(w));
//		
//			}
			
		 //9) Fetch all doctors information of all records from Doctor03 and Stethoscope table
		//hql ile
			// ne varsa getirin yani Full join
		
		
		
		
		
		tx.commit();
		session.close();
		sf.close();

	}

}
