package sen_doctor.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sen_doctor.repository.ProfessionnalRepository;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UnitTestProfessionnal {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProfessionnalRepository professionnalRepository;

    @Test
    public void contextLoads() throws Exception {
        Mockito.when(professionnalRepository.findAll()).thenReturn(Collections.emptyList());
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/professionnals")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        Mockito.verify(professionnalRepository).findAll();

    }
}
