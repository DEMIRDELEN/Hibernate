package odev;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "Sorular")
//@NamedQueries({
//        @NamedQuery(name = "Question.findAll", query = "from Question"),
//        @NamedQuery(name = "Question.findById", query = "from Question where id=:id"),
//        @NamedQuery(name = "Question.findByName", query = "from Question where name=:name"),
//        @NamedQuery(name = "Question.findByPriority", query = "from Question where priority=:priority")})
public class Question extends BaseEntity{


    @Enumerated(EnumType.STRING)
    @Column(name = "Oncelik_derecesi")
    private Priority priority;
    @Column(name = "Soru_ismi")
    private String name;

    @OneToOne(mappedBy = "question", orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    //@JoinColumn(nullable = false, unique = true)
    private QuestionDetail questionDetail;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(Priority priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public QuestionDetail getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(QuestionDetail questionDetail) {
        this.questionDetail = questionDetail;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question" +
                "\npriority: " + priority +
                "\nname: " + name ;
    }
}
