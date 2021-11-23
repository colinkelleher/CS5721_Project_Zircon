package CS5721.project.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CS5721.project.employee.entity.CompanyEntity;

@Repository
public interface CompanyEntityRepository extends JpaRepository<CompanyEntity, Long> {

}
