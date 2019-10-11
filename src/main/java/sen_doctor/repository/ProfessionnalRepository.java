package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sen_doctor.model.Professionnal;

@RepositoryRestResource
public interface ProfessionnalRepository extends JpaRepository<Professionnal, Long> {
     Professionnal findByEmail(String userEmail);
}
