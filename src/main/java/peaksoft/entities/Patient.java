package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="patients" )
@Getter@Setter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patient_id_gen")
    @SequenceGenerator(name = "patient_id_gen",sequenceName = "patient_id_seq",allocationSize = 1)
    private Long id;

    @Size(min=2, max = 60,message = "FirstName should be between 2 and 60 characters!")
    @NotEmpty(message = "FirstName should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @Size(min=2,max = 50,message = "LastName should be between 2 and 50 characters!")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Phone_number should not be empty")
    @Column(name="phone_number")
    private String phoneNumber;

    
    private Gender gender;

    @Column(unique = true)
    private String email;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},
    fetch = FetchType.EAGER)
    private Hospital hospital;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Appointment> appointments=new ArrayList<>();

}
