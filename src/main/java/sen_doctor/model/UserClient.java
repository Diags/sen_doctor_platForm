package sen_doctor.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated UserClient ID")
    private Long id ;
    @ApiModelProperty(notes = "Email for client user")
    private String email;
    @ApiModelProperty(notes = "Password for client user")
    private String password;
    @OneToOne
    @ApiModelProperty(notes = "Adresse for client user")
    private Adresse adresse;
}
