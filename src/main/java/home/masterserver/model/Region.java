package home.masterserver.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Region {
    @Id
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String region) {
        this.name = name;
    }
}
