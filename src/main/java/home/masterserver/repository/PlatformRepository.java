package home.masterserver.repository;

import home.masterserver.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
    Platform findByName(String name);
    boolean existsByName(String name);
}