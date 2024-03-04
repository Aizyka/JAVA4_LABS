package home.masterserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import home.masterserver.model.profiles.ClassifiedSiteProfile;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonIgnore
    private String secret;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private User user;
    @ManyToOne
    private Platform loginPlatform;
    @ManyToOne
    private Platform creationPlatform;
    @ManyToOne
    private Region region;
    private LocalDateTime creationDate;
    private LocalDateTime loginDate;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private ClassifiedSiteProfile classifiedSiteProfile;

    public UserProfile() {
        this.creationDate = LocalDateTime.now();
        this.loginDate = this.creationDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public User getUser() {
        return user;
    }
    public Platform getLoginPlatform() {
        return loginPlatform;
    }
    public void setLoginPlatform(Platform loginPlatform) {
        this.loginPlatform = loginPlatform;
    }
    public Platform getCreationPlatform() {
        return creationPlatform;
    }
    public void setCreationPlatform(Platform creationPlatform) {
        this.creationPlatform = creationPlatform;
    }
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }
    public LocalDateTime getCreationTime() {
        return creationDate;
    }
    public LocalDateTime getLoginDate() {
        return loginDate;
    }
    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }
}