package home.masterserver.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Platform {
    @Id
    private String platform;

    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
