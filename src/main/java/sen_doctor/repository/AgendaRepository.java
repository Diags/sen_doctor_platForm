package sen_doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sen_doctor.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
