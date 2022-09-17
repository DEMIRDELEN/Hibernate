package practice4.onetomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Appointment.class)
				.addAnnotatedClass(Patient.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		/*
	 	Note: If a table has child table, you cannot delete records from parent table.
	 	If you insist to delete records from parent table you have 2 options;
	 	a)Delete child records first then delete parent records.
	 	b)By using annotation we can tell to Hibernate like;
	 	  If I delete parent delete child
	 */

		// 1- 1001 id li patient in get methodu kullanarak appointmentlerini yazdirin
		Patient pt1=session.get(Patient.class, 1001);
		pt1.getAppointmentList().forEach(System.out::println);
		
		// 2- SQL query hastanin randevu bilgilerini getirelim
//		String sqlQuery="select p.patient_name, a.name from Patient p "
//				+ "inner join Appointment a on p.id=a.pt_id";
//		
//		List<Object[]> resultList=session.createSQLQuery(sqlQuery).getResultList();
//		
//		for (Object[] w : resultList) {
//			System.out.println(Arrays.toString(w));
//		}//sql query de varsa column name leri kullaniriz yoksa orjinal isimleri kullaniriz
		
		// 3- hql query hasta nin randevu bilgilerini getirelim
//		String hqlQuery="select p.name , a.name from Patient p "
//				+ "inner join fetch Appointment a on p.id=a.patient";
//		
//		List<Object[]> resultList=session.createQuery(hqlQuery).getResultList();
//		resultList.forEach(t->System.out.println(Arrays.toString(t)));
	
		// 4- patient table siliniz 
//		String sqlQuery="delete from Patient";
//		int numOfRecord=session.createSQLQuery(sqlQuery).executeUpdate();
//		System.out.println("etkilenen ver sayisi"+numOfRecord);
//		
		
		// 5- Appointment table siliniz 
//		String sqlQuery="delete from Appointment";
//		int numOfRecord=session.createSQLQuery(sqlQuery).executeUpdate();
//		System.out.println("etkilenen ver sayisi"+numOfRecord);
		
		//6 tum verileri console da yazdirin sql ile 
//		String sqlQuery ="select * from Appointment";
//		List<Object[]> resultList=session.createSQLQuery(sqlQuery).getResultList();
//		for (Object[] w : resultList) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//7- 1001 id li patient in randevusunu siliniz hql ile
//		String hqlQuery="delete from Appointment where patient=1001";
//		int numOfRecord=session.createQuery(hqlQuery).executeUpdate();
//		System.out.println("etkilenen ver sayisi "+numOfRecord);
		
		 //8- 1003 id li patient i session in get methodu siliniz
//		Patient pt=session.get(Patient.class, 1003);//1003 id li hasta geldi
//		session.delete(pt);//1003 id li hastayi sildi
//		
		//9- Fetch the owner of a appointment whose id is 103 by 
		//using get() method
		
		Appointment app=session.get(Appointment.class, 103);
		Patient pt=session.get(Patient.class, app.getPatient().getId());
		System.out.println(pt);
		
		
		
		
		tx.commit();
		session.close();
		sf.close();

	}
}
