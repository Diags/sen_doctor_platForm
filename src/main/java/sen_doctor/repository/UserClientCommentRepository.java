package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.UserClientComment;

public interface UserClientCommentRepository extends JpaRepository<UserClientComment,Long> {
}
