package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "professionnal")
    private List<Professionnal> professionnals;
    @ApiModelProperty(notes = "The category of this Speciality")
    @JsonManagedReference
    @ManyToOne
    private Category category;



}
