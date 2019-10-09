package sen_doctor.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserClientComment {
    @ApiModelProperty(notes = "The database generated UserClientComment ID")
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ApiModelProperty(notes = "This field specify the user client who puts comment")
    private String createBy;
    @ApiModelProperty(notes = "List of comments that professionnal can have")
    @ElementCollection
    @CollectionTable
    private Collection<String> comment = new ArrayList<>();
    @ApiModelProperty(notes = "fetch  professionnal who has comment ")
    @ManyToOne(cascade = CascadeType.ALL)
    private Professionnal professionnal ;
}
