package Deneme1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Yazilimci")
public class developers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private long id;

    @Column(name = "isim")
    private String name;

    @Column(name = "soy_isim")
    private String surname;

    @Embedded
    @Column(name = "calisma_yeri")
    private WorkPlace workPlace;

    @Transient
    @Column(name = "email_adresi")
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY) // manytomany için FetchType default Lazy zaten.
    @JoinTable(
            name = "Yazilimci_bilgileri",
            joinColumns = {@JoinColumn(
                    name = "yazilimci_id")
            },
            inverseJoinColumns = {@JoinColumn(
                    name = "yazilim_dili_id")
            }
    )
    private List<Language> Language = new ArrayList<>();

    public developers() {
    }

    public developers(String name, String surname, WorkPlace workPlace, List<Deneme1.Language> language) {
        this.name = name;
        this.surname = surname;
        this.workPlace = workPlace;
        this.Language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public WorkPlace getWorkPlace() {
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
                "\nid: " + id +
                "\nname: " + name +
                "\nsurname: " + surname +
                "\nworkPlace: " + workPlace +
                "\nemail: " + email +
                "\nLanguage: " + Language;
    }
}
