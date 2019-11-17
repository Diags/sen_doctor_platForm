package sen_doctor.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sen_doctor.dto.LoginParam;
import sen_doctor.dto.RegisterProfessionalParam;
import sen_doctor.model.Professional;
import sen_doctor.repository.ProfessionalRepository;
import sen_doctor.service.ParmSearchProfessionnalBySpecialityAndTown;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class ProfessionnalController {
    @Autowired
    private ProfessionalRepository professionalRepository;

    @ApiOperation(value = "retreive user image from id")
    @GetMapping(path = "/profesionnalimage/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getProfessionalImage(@PathVariable("id") Long id) throws Exception {
        Professional professional = professionalRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("docimages/" + professional.getPhotoName() + ".png").toURI()));
    }

    @ApiOperation(value = "retreive professional from database")
    @GetMapping(path = "/proffesionnals")
    public List<Professional> getProfessionals() {
        return professionalRepository.findAll();
    }

    @ApiOperation (value= "retreive professional in specifique fonction and town from database ")
    @PostMapping("/searchprofesionnalbytown")
    public List<Professional> getProfesionnalsBySpecialityAndTwon(@RequestBody() ParmSearchProfessionnalBySpecialityAndTown param) throws Exception {
        List<Professional> professionals = professionalRepository.getBySpecialityTown(param.getName(), param.getTown());
        if(professionals == null){
            throw new Exception("Pas de professional dans cette ville");
        }
        return professionals;
    }

    @ApiOperation(value = "retreive professional from database")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR')")
    @GetMapping(path = "/deleteProfessional/{id}")
    public void deleteProfessionalById(@PathVariable("id") Long id) {
        professionalRepository.deleteById(id);
    }

    @ApiOperation(value = "delete professional from database")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR')")
    @GetMapping(path = "/updateProfessional")
    public Professional updateProfessionalById(@RequestBody Professional professional) {
       // Objects.requireNonNull(professional, "Thes proessionnal must not be null or empty");
        Professional professionalDB = professionalRepository.findById(professional.getId()).get();
       // Objects.requireNonNullElse(professionalDB, new UserNotFoundException(professionalDB));
        professionalRepository.save(professionalDB);
        return professionalDB;
    }

    @ApiOperation(value = "add professional to database")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR')")
    @GetMapping(path = "/addProfessional")
    public Professional addProfessionalById(@RequestBody Professional professional) {
       // Objects.requireNonNull(professional, "Thes proessionnal must not be null or empty");
        Professional professionalDB = professionalRepository.findById(professional.getId()).get();
       // Objects.requireNonNullElse(professionalDB, new UserNotFoundException(professionalDB));
        professionalRepository.save(professionalDB);
        return professionalDB;
    }

    @ApiOperation(value = "login  professional to database")
    @GetMapping(path = "/loginprofessionnal")
    public Professional login(@RequestBody LoginParam loginParam) {
        //Objects.requireNonNull(loginParam, "Thes proessionnal must not be null or empty");
        Professional professionalDB = professionalRepository.findByEmail(loginParam.getEmail());
        //Objects.requireNonNullElse(professionalDB, new UserNotFoundException(professionalDB));
        professionalRepository.save(professionalDB);
        return professionalDB;
    }

    @ApiOperation(value = "login  professional to database")
    @GetMapping(path = "/registerprofessional")
    public Professional register(@RequestBody RegisterProfessionalParam registerProfessionalParam) {
       // Objects.requireNonNull(registerProfessionalParam, "Thes proessionnal must not be null or empty");
        Professional professionalDB = professionalRepository.findByEmail(registerProfessionalParam.getEmail());
       // Objects.requireNonNullElse(professionalDB, new UserNotFoundException(professionalDB));
        professionalRepository.save(professionalDB);
        return professionalDB;
    }

}
