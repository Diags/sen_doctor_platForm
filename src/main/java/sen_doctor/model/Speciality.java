package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated speciality ID")
    private Long id ;
    @ApiModelProperty(notes = "Speciality name")
    private String name;
    @ApiModelProperty(notes = "The image name of the speciality")
    private String photo;
    @ApiModelProperty(notes = "The speciality description")
    private String description;
    @ApiModelProperty(notes = "The list of professionnal for this  speciality")
    @JsonBackReference
    @OneToMany(mappedBy = "speciality")
    private Collection<Professional> professionals;
}
