package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import sen_doctor.model.Professional;
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
     Professional findByEmail(String userEmail);
}
