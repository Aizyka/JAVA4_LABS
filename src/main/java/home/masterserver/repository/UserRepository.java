package home.masterserver.repository;

import home.masterserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
}