package sen_doctor.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sen_doctor.SenDoctorApplication;
import sen_doctor.controller.ProfessionnalController;
import sen_doctor.repository.ProfessionalRepository;

import java.util.Collections;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SenDoctorApplication.class
)
@AutoConfigureMockMvc
public class SenDoctorUnitTest {
    @MockBean
    private ProfessionalRepository professionalRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProfesionnal() throws Exception {
        Mockito.when(professionalRepository.findAll()).thenReturn(Collections.emptyList());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/proffesionnals")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString() + " this is response");
        Mockito.verify(professionalRepository).findAll();
    }

}
