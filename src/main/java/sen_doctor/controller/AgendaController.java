package sen_doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sen_doctor.repository.ProfessionalRepository;

@RestController
public class AgendaController {
    @Autowired
    private ProfessionalRepository professionalRepository;

}
