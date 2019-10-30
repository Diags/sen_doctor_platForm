package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
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
    @JsonManagedReference
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Professional professional;
}
