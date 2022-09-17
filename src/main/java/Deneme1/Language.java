package Deneme1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Language_id")
    private long id;

    @Column(name = "yazilim_dilleri")
    private String software_languages;

    @ManyToMany(mappedBy = "Language", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private List<developers> developers = new ArrayList<>();

    public Language() {
    }

    public Language(String software_languages) {
        this.software_languages = software_languages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSoftware_languages() {
        return software_languages;
    }

    public void setSoftware_languages(String software_languages) {
        this.software_languages = software_languages;
    }

    public List<Deneme1.developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Deneme1.developers> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Language" +
                "\nid: " + id +
                "\nsoftware_languages: " + software_languages +
                "\ndevelopers: " + developers ;
    }
}
