package odev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class RunnerFetch {

    public static void main(String[] args) {


        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Question.class).addAnnotatedClass(QuestionDetail.class).
                addAnnotatedClass(Answer.class).addAnnotatedClass(Priority.class).
                addAnnotatedClass(BaseEntity.class).buildSessionFactory();

        Session session1 = sf.openSession();

        Transaction tx = session1.beginTransaction();


        //"get" methodu ile sorgu yapma

        //Question q1 = session1.get(Question.class, 1L);
        //System.out.println("q1'in name : " + q1.getName());

        //Question q2 = session1.get(Question.class, 2L);
        //System.out.println("q2 : " + q2);

        //Not: Question class'ındaki ToString methodunda diğer classlarla bağlandı kurduğumuz sütunlar olmadığı için q1 objesini yazdırınca sadece method da bulunan değerleri alıyoruz. Eğer verilerin tamamen yazdırmak
        //     istiyorsak get methodlarını concet edebiliriz. Örnek: System.out.println("q2 = " + q2+q2.getAnswers()+q2.getQuestionDetail());
        //     ToString methodu kullanamama sebebimiz ise diğer ToString methodları ile çakışmalar sebebiyle oluşan StackOwerFlow hatası almamızdır.

        //QuestionDetail qd1 = session1.get(QuestionDetail.class, 1L);
        //System.out.println("qd1 = " + qd1);

        //Answer a1 = session1.get(Answer.class, 1L);
        //System.out.println("a1 = " + a1);

        //Sql sorguları ile sorgu yapma

        //String sql1 = "select * from Sorular";
        //List<Object[]> names = session1.createSQLQuery(sql1).getResultList();
        //for (Object[] each : names
        //) {
        //    System.out.println(Arrays.toString(each));
        //}


        String sql2 = "select Soru_ismi from Sorular where Oncelik_derecesi='CRITICAL'";
        Object[] result1 = (Object[]) session1.createSQLQuery(sql2).uniqueResult();
        System.out.println(Arrays.toString(result1));


    }
}
