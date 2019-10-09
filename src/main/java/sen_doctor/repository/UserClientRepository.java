package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.UserClient;

public interface UserClientRepository extends JpaRepository<UserClient,Long> {
}
