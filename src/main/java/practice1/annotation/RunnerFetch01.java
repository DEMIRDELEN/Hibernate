package practice1.annotation;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
	
		Doctor01 dr10=new Doctor01();
		Doctor01 dr20=new Doctor01();
		Doctor01 dr30=new Doctor01();
		Doctor01 dr40=new Doctor01();
		
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Doctor01.class);
		
		SessionFactory sf=con.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
//		dr10=session.get(Doctor01.class, 1001);
//		dr20=session.get(Doctor01.class, 1002);
//		dr30=session.get(Doctor01.class, 1003);
//		dr40=session.get(Doctor01.class, 1004);
//		
//		
//		System.out.println(dr10);
//		System.out.println(dr20);
//		System.out.println(dr30);
//		System.out.println(dr40);
		
		
		//sql ve hql sorgulari ile tbl_doctor table indan verileri getiren sorgulari yaziniz
		//sql ile
//		String sqlQuery1 ="select * from tbl_doctor";
//		List<Object[]> resultList1=session.createSQLQuery(sqlQuery1).getResultList();
//		
//		for (Object[] w : resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		//hql note hql sizin orjinal yani ilk ismi class ve degisken isimlerinize bakar
//		String hqlQuery1="from Doctor01";
//		List <Doctor01> resultList2=session.createQuery(hqlQuery1).getResultList();
//		for (Doctor01 dr : resultList2) {
//			System.out.println(dr);
//		}
		
		//doctor ismi fatih polat olan doktoru getiren sorgu yaziniz
//		String sqlQuery1="select * from tbl_doctor where doctor_name='fatih polat'";
//		Object[] result1= (Object[])session.createSQLQuery(sqlQuery1).uniqueResult();
//		
//		System.out.println(Arrays.toString(result1));
//		
		//hql ile 
//		String hqlQuery1="from Doctor01 where name='fatih polat'";
//		List <Doctor01> resultList2=session.createQuery(hqlQuery1).getResultList();
//		
//			System.out.println(resultList2);
	
		// HQL ile Alias kullanma ile yapiniz odev 
		//branch kbb olan doctorlari getirin
		
		//id ye gore terstten sirali getiren hql query yaziniz 
		
		String hqlQuery1="from Doctor01 d order by d.id desc";
		List<Doctor01> resultList=session.createQuery(hqlQuery1, Doctor01.class).getResultList();
		for (Doctor01 dr : resultList) {
			System.out.println(dr);
		}
		
		
	
		//doctor class ina education table i embbed ediniz
		
		//onetoone iliskisi kuracak class create ediniuz
		
		
		
		
		tx.commit();
		session.close();
		sf.close();

	}

}
