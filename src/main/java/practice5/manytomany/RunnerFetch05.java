package practice5.manytomany;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor05.class)
                .addAnnotatedClass(Patient.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 1- 1001 id li doktorun i get methodu kullanarak patientlerini yazdirin
//		Doctor05 dr1=session.get(Doctor05.class, 1001);
//		//System.out.println(dr1.getPatientList());
//		dr1.getPatientList().forEach(System.out::println);
//
        // 2- 101 id li patientin get methodu ile dr larini getirirn
//		Patient pt1=session.get(Patient.class, 102);
//		pt1.getDoctors().forEach(System.out::println);
//
//
        // 3- dr ve patient bilgileriniz getiriniz hql ile
        String hqlQuery="select d from Doctor05 d join fetch d.patientList ";
        List<Doctor05> resultList=session.createQuery(hqlQuery,Doctor05.class).getResultList();
        for (Doctor05 w : resultList) {
            System.out.println(w);
        }








        tx.commit();
        session.close();
        sf.close();
    }
}