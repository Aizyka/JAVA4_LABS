package home.masterserver.repository;

import home.masterserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
}