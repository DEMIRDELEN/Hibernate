package Deneme1;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorkPlace {

    @Column(name = "sirket")
    private String company;

    @Column(name = "ulke")
    private String country;

    public WorkPlace() {
    }

    public WorkPlace(String company, String country) {
        this.company = company;
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "WorkPlace" +
                "\ncompany: " + company +
                "\ncountry: " + country ;
    }
}
