package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Professionnal;

public interface ProfessionnalRepository extends JpaRepository<Professionnal, Long> {
}
