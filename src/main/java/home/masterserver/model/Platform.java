package home.masterserver.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Platform {
    @Id
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
