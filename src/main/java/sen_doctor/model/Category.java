package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated category ID")
    private Long id;
    @ApiModelProperty(notes = "The name of category")
    private String name;
    @ApiModelProperty(notes = "The  category  description")
    private String description;
    @ApiModelProperty(notes = "The  image url name of category")
    private String photo;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    @ApiModelProperty(notes = "The collection of specialities")
    private Collection<Speciality> specialities;


}
