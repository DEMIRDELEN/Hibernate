package odev;

import javax.persistence.*;

@Entity
@Table(name = "soru_detayi")
public class QuestionDetail extends BaseEntity{

    @Column(name = "Soru_Tanımı")
    private String description;

    @OneToOne(orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    private Question question;


    public QuestionDetail() {
    }


    public QuestionDetail(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionDetail" +
                "\nDescription: " + description +
                "\nQuestion: " + question;
    }
}
