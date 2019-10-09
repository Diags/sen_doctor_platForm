package sen_doctor.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Generated  id automaticaly in database")
    private Long id;
    @ApiModelProperty(notes = "date of formation")
    private Date dateFormation;
    @ApiModelProperty(notes = "Formation of proffessionnal")
    private String formationDescription;
    @ApiModelProperty(notes = "Date experience of proffessionnal")
    private Date dateExperience;
    @ApiModelProperty(notes = "Experience of proffessionnal")
    private String experience;
}
