package sen_doctor.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sen_doctor.model.Professional;
import sen_doctor.model.Speciality;
import sen_doctor.repository.SpecialityRepository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class SpecialityController {
    @Autowired
    private SpecialityRepository specialityRepository;

    @ApiOperation(value = "retreive pro image from id")
    @GetMapping(path = "/specialistimage/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getSpecialityImageByProfessionalId(@PathVariable("id") Long id) throws Exception {
        Speciality speciality  = specialityRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("docimages/catalogue" + speciality.getPhoto() + ".png").toURI()));
    }

    @GetMapping("/specialities")
    public ResponseEntity<List<Speciality>> getSpecialities() throws Exception {
        List<Speciality> specialities = specialityRepository.findAll();
        if (specialities == null) {
            throw new Exception("Pas de spécialiste trouvé");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialities);
    }

}
