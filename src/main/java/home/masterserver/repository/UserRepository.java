package home.masterserver.repository;

import home.masterserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
}