package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import sen_doctor.model.Professional;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

     Professional findByEmail(String userEmail);
    //@Query("select u from User u  where  u.profession.name =:name and u.adresse.ville =:ville")
    List<Professional> getBySpeciality_NameAndAdresse_Town(String specialit, String townName);

}
