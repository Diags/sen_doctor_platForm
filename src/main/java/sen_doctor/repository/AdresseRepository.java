package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sen_doctor.model.Adresse;

@RepositoryRestResource
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
}
