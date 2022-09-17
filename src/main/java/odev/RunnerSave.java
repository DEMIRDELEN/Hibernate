package odev;

import com.hb13.get_load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunnerSave {

    public static void main(String[] args) {


        Answer a1 = new Answer("Answer-1", "............");
        Answer a2 = new Answer("Answer-2", "............");
        Answer a3 = new Answer("Answer-3", "............");
        Answer a4 = new Answer("Answer-4", "............");
        Answer a5 = new Answer("Answer-5", "............");
        Answer a6 = new Answer("Answer-6", "............");
        Answer a7 = new Answer("Answer-7", "............");
        Answer a8 = new Answer("Answer-8", "............");

        List<Answer> answerList1 = Arrays.asList(a1, a2, a3);
        List<Answer> answerList2 = Arrays.asList(a4, a5, a6);
        List<Answer> answerList3 = Arrays.asList(a7, a8);

        QuestionDetail qd1 = new QuestionDetail("..............");
        QuestionDetail qd2 = new QuestionDetail("..............");

        Question q1 = new Question(Priority.CRITICAL, "Question-1", qd1, answerList1);
        Question q2 = new Question(Priority.HIGH, "Question-2", qd2, answerList2);
        Question q3 = new Question(Priority.LOW, "Question-3", qd2, answerList3);


        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Question.class).addAnnotatedClass(QuestionDetail.class).addAnnotatedClass(Answer.class).
                addAnnotatedClass(Priority.class).addAnnotatedClass(BaseEntity.class).buildSessionFactory();
        Session session1 = sf.openSession();

        Transaction tx = session1.beginTransaction();

        session1.save(a1);
        session1.save(a2);
        session1.save(a3);
        session1.save(a4);
        session1.save(a5);
        session1.save(a6);
        session1.save(a7);
        session1.save(a8);

        session1.save(qd1);
        session1.save(qd2);

        session1.save(q1);
        session1.save(q2);
        session1.save(q3);




    }
}
