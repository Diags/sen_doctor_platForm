package sen_doctor.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated payement ID")
    private Long  id;
    @ApiModelProperty(notes = "Kind of payement: cheque, espece, card")
    private String kind;
    @ApiModelProperty(notes = "Field or level of professionnal ")
    private String secteur;
    @ApiModelProperty(notes = "Intervention price of professionnal")
    private String price;

}
