package home.masterserver.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "\"user\"")
public class User {
    @Id
    private String login;
    private String password;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private UserProfile profile;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserProfile getProfile() {
        return profile;
    }
    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}