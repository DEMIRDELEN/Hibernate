package odev;

import javax.persistence.*;

@Entity
@Table(name = "cevaplar")
public class Answer {

    @Column(name = "Cevap_ismi")
    private String isim;

    @Column(name = "cevap_açıklamaları")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "Soru", nullable = false, unique = true)
    private Question question;

    public Answer() {
    }

    public Answer(String isim, String description) {
        this.isim = isim;
        this.description = description;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
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
                "\nisim: " + isim +
                "\nDescription: " + description +
                "\nQuestion: " + question ;
    }
}
