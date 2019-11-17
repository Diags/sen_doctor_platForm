package sen_doctor.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParmSearchProfessionnalBySpecialityAndTown {
    private String name;
    private String town;
}
