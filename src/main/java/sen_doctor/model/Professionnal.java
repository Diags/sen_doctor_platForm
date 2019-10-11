package sen_doctor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Professionnal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Generated automatically id in data base")
    private Long id;
    //  @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 26)
    @ApiModelProperty(notes = "Proffessionnal first name")
    @NotBlank
    private String firstName;
    @ApiModelProperty(notes = "Proffessionnal last name")
    // @Pattern(regexp = "^[a-zA-Z\\s]+$")
    @Size(min = 3, max = 26)
    @NotBlank
    private String lastName;
    @ApiModelProperty(notes = "Proffessionnal name with determinant")
    private String nameWithDeternimant;
    @ApiModelProperty(notes = "Proffessionnal name with title")
    private String nameWithTtle;
    //    @ApiModelProperty(notes = "Proffessionnal agenda")
//    private Agenda agenda;
    @ApiModelProperty(notes = "Proffessionnal photo name")
    private String photoName;
    //    @ApiModelProperty(notes = "Proffessionnal payment")
//    @NotBlank
//    private Payement payement;
    @OneToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Proffessionnal adresse")
    private Adresse adresse;
    @ApiModelProperty(notes = "Proffessionnal description")
    private String description;
    @ApiModelProperty(notes = "Proffessionnal password")
    @NotBlank
    private String password;
    @ApiModelProperty(notes = "Proffessionnal email")
    @Email
    @NotBlank
    private String email;
    @ApiModelProperty(notes = "Proffessionnal agenda")
    @NotBlank
    private String confirmPassword;
    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.REMOVE)
    @JoinTable(
            indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "id_professional")},
            name = "roles",
            joinColumns = @JoinColumn(name = "id_professional")
    )
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Collection<RoleEnum> roles;
    //    @ElementCollection(targetClass = HashMap.class)
//    private Map<String, List<String>> commentaires = new HashMap<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private Collection<UserClientComment> userClientComments = new ArrayList<>();
    @OneToMany(mappedBy = "professionnal")
    @JsonBackReference
    private Collection<Study> studies;
    @JsonManagedReference
    @ManyToOne
    private Speciality speciality;

}
