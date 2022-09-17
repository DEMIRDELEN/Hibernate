package Deneme1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Arrays;
import java.util.List;

public class RunnerSave {
    public static void main(String[] args) {

        WorkPlace workPlace1 = new WorkPlace("Google", "USA");
        WorkPlace workPlace2 = new WorkPlace("SpaceX", "USA");
        WorkPlace workPlace3 = new WorkPlace("Amazon", "USA");
        WorkPlace workPlace4 = new WorkPlace("Microsoft", "USA");
        WorkPlace workPlace5 = new WorkPlace("Huawei", "China");

        Language lng1 = new Language("C");
        Language lng2 = new Language("C+");
        Language lng3 = new Language("C++");
        Language lng4 = new Language("C#");
        Language lng5 = new Language("Python");
        Language lng6 = new Language("Java");
        Language lng7 = new Language("JavaScript");
        Language lng8 = new Language("R");
        Language lng9 = new Language("Php");
        Language lng10 = new Language("Go");
        Language lng11 = new Language("Ruby");
        Language lng12 = new Language("Assembly");

        List<Language> dev1_lng = Arrays.asList(lng1, lng2, lng3, lng4, lng5);
        List<Language> dev2_lng = Arrays.asList(lng3, lng4, lng5, lng6, lng7);
        List<Language> dev3_lng = Arrays.asList(lng5, lng6, lng7, lng8, lng9);
        List<Language> dev4_lng = Arrays.asList(lng7, lng8, lng9, lng10, lng11);
        List<Language> dev5_lng = Arrays.asList(lng9, lng10, lng11, lng12);

        developers dev1 = new developers("John", "Rockefeller", workPlace1, dev1_lng);
        developers dev2 = new developers("Elon", "Musk", workPlace2, dev2_lng);
        developers dev3 = new developers("Jeff", "Bezos", workPlace3, dev3_lng);
        developers dev4 = new developers("Bill", "Gates", workPlace4, dev4_lng);
        developers dev5 = new developers("Warren", "Buffet", workPlace5, dev5_lng);


        Session session1 = sessionFactoryMethod.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();

        session1.save(lng1);
        session1.save(lng2);
        session1.save(lng3);
        session1.save(lng4);
        session1.save(lng5);
        session1.save(lng6);
        session1.save(lng7);
        session1.save(lng8);
        session1.save(lng9);
        session1.save(lng10);
        session1.save(lng11);
        session1.save(lng12);

        session1.save(dev1);
        session1.save(dev2);
        session1.save(dev3);
        session1.save(dev4);
        session1.save(dev5);


        tx.commit();
        session1.close();
        sessionFactoryMethod.shutdown();
    }
}
