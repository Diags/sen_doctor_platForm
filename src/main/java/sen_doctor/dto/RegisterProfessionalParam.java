package sen_doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterProfessionalParam {
    private String email;
    private String password;
    private String confirmPassword;
}
