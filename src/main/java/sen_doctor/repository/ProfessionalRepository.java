package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sen_doctor.model.Professional;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

     Professional findByEmail(String userEmail);

    @Query("select distinct u from Professional u  where  u.speciality.name =:name and u.adresse.town =:ville")
    List<Professional> getBySpecialityTown(@Param("name") String name, @Param("ville") String ville);

}
