package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
