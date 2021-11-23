package CS5721.project.clocking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CS5721.project.clocking.entity.ClockingInfo;

@Repository
public interface ClockingInfoRepository extends JpaRepository<ClockingInfo, Long> {

}
