package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@Setter@Getter
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="doctor_id_gen")
    @SequenceGenerator(name = "doctor_id_gen",sequenceName = "doctor_id_seq",allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String position;
    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Department> departments;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Appointment> appointments=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Hospital hospital;

}
