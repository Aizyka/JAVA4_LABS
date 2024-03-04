package home.masterserver.model.profiles;

import home.masterserver.model.UserProfile;
import jakarta.persistence.*;

@Entity
public class ClassifiedSiteProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "classifiedSiteProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserProfile userProfile;
    @ManyToOne
    private ClassifiedSiteRule rule;
    private String globalBan;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserProfile getUserProfile() {
        return userProfile;
    }
    public ClassifiedSiteRule getRule() {
        return rule;
    }
    public void setRule(ClassifiedSiteRule rule) {
        this.rule = rule;
    }
    public String getGlobalBan() {
        return globalBan;
    }
    public void setGlobalBan(String globalBan) {
        this.globalBan = globalBan;
    }
}
