package sen_doctor.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sen_doctor.model.Professionnal;
import sen_doctor.repository.ProfessionnalRepository;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ProfessionnalController {
    @Autowired
    private ProfessionnalRepository professionnalRepository;
    @ApiOperation(value = "retreive user image from id")
    @GetMapping(path = "/profesionnalimage/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getProfessionalImage(@PathVariable("id") Long id) throws Exception {
        Professionnal professionnal = professionnalRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("imageDiaguily/image/" + professionnal.getPhotoName() + ".png").toURI()));
    }
}
