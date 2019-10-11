package sen_doctor.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sen_doctor.dto.LoginParam;
import sen_doctor.dto.RegisterProfessionalParam;
import sen_doctor.errorHandle.UserNotFoundException;
import sen_doctor.model.Professionnal;
import sen_doctor.repository.ProfessionnalRepository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@RestController
public class ProfessionnalController {
    private ProfessionnalRepository professionnalRepository;

    @Autowired
    public ProfessionnalController(ProfessionnalRepository professionnalRepository) {
        this.professionnalRepository = professionnalRepository;
    }

    @ApiOperation(value = "retreive user image from id")
    @GetMapping(path = "/profesionnalimage/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getProfessionalImage(@PathVariable("id") Long id) throws Exception {
        Professionnal professionnal = professionnalRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("docimages/" + professionnal.getPhotoName() + ".png").toURI()));
    }

    @ApiOperation(value = "retreive professional from database")
    @GetMapping(path = "/proffesionnals")
    public List<Professionnal> getProfessionals() {
        return professionnalRepository.findAll();
    }

    @ApiOperation(value = "retreive professional from database")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR')")
    @GetMapping(path = "/deleteProfessional/{id}")
    public void deleteProfessionalById(@PathVariable("id") Long id) {
        professionnalRepository.deleteById(id);
    }

    @ApiOperation(value = "delete professional from database")
    @GetMapping(path = "/deleteProfessional")
    public Professionnal updateProfessionalById(@RequestBody Professionnal professionnal) {
        Objects.requireNonNull(professionnal, "Thes proessionnal must not be null or empty");
        Professionnal professionnalDB = professionnalRepository.findById(professionnal.getId()).get();
        Objects.requireNonNullElse(professionnalDB, new UserNotFoundException(professionnalDB));
        professionnalRepository.save(professionnalDB);
        return professionnalDB;
    }

    @ApiOperation(value = "add professional to database")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR')")
    @GetMapping(path = "/addProfessional")
    public Professionnal addProfessionalById(@RequestBody Professionnal professionnal) {
        Objects.requireNonNull(professionnal, "Thes proessionnal must not be null or empty");
        Professionnal professionnalDB = professionnalRepository.findById(professionnal.getId()).get();
        Objects.requireNonNullElse(professionnalDB, new UserNotFoundException(professionnalDB));
        professionnalRepository.save(professionnalDB);
        return professionnalDB;
    }

    @ApiOperation(value = "login  professional to database")
    @GetMapping(path = "/loginprofessionnal")
    public Professionnal login(@RequestBody LoginParam loginParam) {
        Objects.requireNonNull(loginParam, "Thes proessionnal must not be null or empty");
        Professionnal professionnalDB = professionnalRepository.findByEmail(loginParam.getEmail());
        Objects.requireNonNullElse(professionnalDB, new UserNotFoundException(professionnalDB));
        professionnalRepository.save(professionnalDB);
        return professionnalDB;
    }

    @ApiOperation(value = "login  professional to database")
    @GetMapping(path = "/registerprofessional")
    public Professionnal register(@RequestBody RegisterProfessionalParam registerProfessionalParam) {
        Objects.requireNonNull(registerProfessionalParam, "Thes proessionnal must not be null or empty");
        Professionnal professionnalDB = professionnalRepository.findByEmail(registerProfessionalParam.getEmail());
        Objects.requireNonNullElse(professionnalDB, new UserNotFoundException(professionnalDB));
        professionnalRepository.save(professionnalDB);
        return professionnalDB;
    }

    public void setProfessionnalRepository(ProfessionnalRepository professionnalRepository) {
        this.professionnalRepository = professionnalRepository;
    }

}
