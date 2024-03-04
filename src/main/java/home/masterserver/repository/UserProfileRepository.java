package home.masterserver.repository;

import home.masterserver.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findBySecret(String secret);
    boolean existsBySecret(String secret);
}