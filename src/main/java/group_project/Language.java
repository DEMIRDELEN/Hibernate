package group_project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "yazilim_dili")
public class Language {

    @Column(name = "yazilim_dilleri")
    private String software_languages;

    @ManyToMany(mappedBy = "Language", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Deneme1.developers> developers = new ArrayList<>();

    public Language() {
    }

    public Language(String software_languages) {
        this.software_languages = software_languages;
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
                "\nsoftware_languages: " + software_languages ;
    }
}

