package home.masterserver.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Region {
    @Id
    private String name;
    @OneToMany(mappedBy = "region")
    private List<UserProfile> profiles;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<UserProfile> getProfiles() {
        return profiles;
    }
}
