package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id generated in data base")
    private Long id;
    @ApiModelProperty(notes = "Adresse road number")
    private int numRoad;
    @ApiModelProperty(notes = "Adresse road name")
    private String roadName;
    @ApiModelProperty(notes = "Adresse code postal ")
    private int codePostal;
    @ApiModelProperty(notes = "Adresse town name")
    private String town;
    @JsonManagedReference
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ApiModelProperty(notes = "Adresse country name")
    private Country country;
    @OneToOne(mappedBy = "adresse")
    @ApiModelProperty(notes = "Adresse of proffessionnal")
    private Professionnal professionnal;
}
