package home.masterserver.repository;

import home.masterserver.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findBySecret(String secret);
    boolean existsBySecret(String secret);
    boolean existsById(Long id);
    @Query("SELECT secret FROM UserProfile WHERE id = :userID")
    String getSecretByID(@Param("userID") Long userID);
}