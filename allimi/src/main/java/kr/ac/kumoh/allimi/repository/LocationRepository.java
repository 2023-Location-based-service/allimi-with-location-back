package kr.ac.kumoh.allimi.repository;

import kr.ac.kumoh.allimi.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<List<Location>> findAllByCityAndRegion(String city, String region);
    Optional<List<Location>> findAllByNameContainingOrAddressContaining(String name, String address);

    Optional<Location> findByNameAndAddress(String name, String address);
}
