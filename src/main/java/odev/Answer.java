package odev;

import javax.persistence.*;

@Entity
@Table(name = "cevaplar")
public class Answer extends BaseEntity{

    @Column(name = "Cevap_ismi",length = 100)
    private String name;

    @Column(name = "cevap_açıklamaları")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Soru")
    private Question question;

    public Answer() {
    }

    public Answer(String isim, String description) {
        this.name = isim;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Answer" +
                "\nisim: " + name +
                "\nDescription: " + description +
                "\nQuestion: " + question ;
    }
}
