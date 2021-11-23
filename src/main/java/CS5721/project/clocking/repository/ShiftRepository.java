package CS5721.project.clocking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CS5721.project.clocking.entity.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {

}