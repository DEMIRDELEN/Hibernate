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

        Answer a1 = new Answer("Answer_1", "................");
        Answer a2 = new Answer("Answer_2", "...............");
        Answer a3 = new Answer("Answer_3", "..............");
        Answer a4 = new Answer("Answer_4", ".............");
        Answer a5 = new Answer("Answer_5", "............");
        Answer a6 = new Answer("Answer_6", "...........");

        List<Answer> q1List = Arrays.asList(a1,a2);
        List<Answer> q2List = Arrays.asList(a3,a4);
        List<Answer> q3List = Arrays.asList(a5,a6);

        QuestionDetail qd1 = new QuestionDetail("................");
        QuestionDetail qd2 = new QuestionDetail("...............");
        QuestionDetail qd3 = new QuestionDetail("..............");

        Question q1 = new Question(Priority.CRITICAL, "Question-1");
        Question q2 = new Question(Priority.HIGH, "Question-2");
        Question q3 = new Question(Priority.LOW, "Question-3");

        q1.setQuestionDetail(qd1);
        q1.setAnswers(q1List);
        q2.setQuestionDetail(qd2);
        q2.setAnswers(q2List);
        q3.setQuestionDetail(qd3);
        q3.setAnswers(q3List);

        a1.setQuestion(q1);
        a2.setQuestion(q1);
        a3.setQuestion(q2);
        a4.setQuestion(q2);
        a5.setQuestion(q3);
        a6.setQuestion(q3);

        qd1.setQuestion(q1);
        qd2.setQuestion(q2);
        qd3.setQuestion(q3);


        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Question.class).addAnnotatedClass(QuestionDetail.class).
                addAnnotatedClass(Answer.class).addAnnotatedClass(Priority.class).
                addAnnotatedClass(BaseEntity.class).buildSessionFactory();

        Session session1 = sf.openSession();

        Transaction tx = session1.beginTransaction();

        session1.save(a1);
        session1.save(a2);
        session1.save(a3);
        session1.save(a4);
        session1.save(a5);
        session1.save(a6);

        session1.save(qd1);
        session1.save(qd2);
        session1.save(qd3);

        session1.save(q1);
        session1.save(q2);
        session1.save(q3);

        tx.commit();
        session1.close();
        sf.close();


    }
}
