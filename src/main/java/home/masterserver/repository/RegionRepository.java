package home.masterserver.repository;

import home.masterserver.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByName(String name);
    boolean existsByName(String name);
}