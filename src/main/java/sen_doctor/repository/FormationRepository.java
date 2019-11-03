package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sen_doctor.model.Formation;

@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation, Long> {
}
