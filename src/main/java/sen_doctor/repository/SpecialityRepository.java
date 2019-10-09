package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
}
