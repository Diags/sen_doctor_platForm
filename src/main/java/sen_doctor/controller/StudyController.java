package sen_doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sen_doctor.repository.ProfessionnalRepository;

@RestController
public class StudyController {
    @Autowired
    private ProfessionnalRepository professionnalRepository;

}
