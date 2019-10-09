package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Study;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
