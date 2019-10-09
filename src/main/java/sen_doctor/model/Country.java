package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Generated  automatically id sessequences in database")
    private Long id;
    @ApiModelProperty(notes = "Country name")
    private String name;
    @ApiModelProperty(notes = "Country code")
    private String code;
    @JsonBackReference
    @OneToMany(mappedBy = "country")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ApiModelProperty(notes = "adresse in country")
    private Collection<Adresse> adresses;
}
