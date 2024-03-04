package home.masterserver.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Region {
    @Id
    private String region;

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
}
