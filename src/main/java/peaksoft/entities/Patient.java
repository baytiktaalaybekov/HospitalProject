package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;

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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="phone_number")
    private String phoneNumber;
    private Gender gender;

    @Column(unique = true)
    private String email;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST},
    fetch = FetchType.EAGER)
    private Hospital hospital;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Appointment> appointments=new ArrayList<>();

}
