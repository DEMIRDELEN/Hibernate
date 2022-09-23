package group_project;

import Deneme1.WorkPlace;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Yazilimci")
public class Developers extends BaseEntity {

    @Column(name = "isim")
    private String name;

    @Column(name = "soy_isim")
    private String surname;

    @Embedded
    @Column(name = "calisma_yeri")
    private Deneme1.WorkPlace workPlace;

    @Transient
    @Column(name = "email_adresi")
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Ortak_Tablo",
            joinColumns = {@JoinColumn(
                    name = "yazilimci_id")
            },
            inverseJoinColumns = {@JoinColumn(
                    name = "yazilim_dili_id")
            }
    )
    private List<Deneme1.Language> Language = new ArrayList<>();

    public Developers() {
    }

    public Developers(String name, String surname, Deneme1.WorkPlace workPlace, List<Deneme1.Language> language) {
        this.name = name;
        this.surname = surname;
        this.workPlace = workPlace;
        this.Language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Deneme1.WorkPlace getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(WorkPlace workPlace) {
        this.workPlace = workPlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Deneme1.Language> getLanguage() {
        return Language;
    }

    public void setLanguage(List<Deneme1.Language> language) {
        Language = language;
    }

    @Override
    public String toString() {
        return "developer" +
                "\nname: " + name +
                "\nsurname: " + surname +
                "\nworkPlace: " + workPlace +
                "\nemail: " + email +
                "\nLanguage: " + Language;
    }
}

