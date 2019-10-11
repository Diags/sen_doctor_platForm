package sen_doctor.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sen_doctor.controller.ProfessionnalController;
import sen_doctor.repository.ProfessionnalRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UnitTestProfessionnal {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProfessionnalRepository professionnalRepository;
    @InjectMocks
    private ProfessionnalController professionnalController;
//    @Before
//    public void setUp(){
//    //    professionnalController = new ProfessionnalController(professionnalRepository);
//        mockMvc = MockMvcBuilders.standaloneSetup(professionnalController).build();
//    }

    @Test
    public void contextLoads() throws Exception {
//        Mockito.when(professionnalRepository.findAll()).thenReturn(Collections.emptyList());
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/professionnals")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//        )
//                //.andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn();
//      //  this.professionnalController.setProfessionnalRepository(professionnalRepository);
//      //  Mockito.verify(professionnalRepository).findAll();

    }
}
