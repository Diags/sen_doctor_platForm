package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Payement;

public interface PayementRepository extends JpaRepository<Payement,Long> {
}
