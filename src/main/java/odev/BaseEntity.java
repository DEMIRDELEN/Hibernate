package odev;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "IDENTITY", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "IDENTITY", sequenceName = "student_ID", initialValue = 1000, allocationSize = 1)

    private Long id;

    @Version
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
