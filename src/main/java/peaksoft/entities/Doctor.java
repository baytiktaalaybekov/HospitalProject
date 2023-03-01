package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "doctors")
@Setter@Getter
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="doctor_id_gen")
    @SequenceGenerator(name = "doctor_id_gen",sequenceName = "doctor_id_seq",allocationSize = 1)
    private Long id;
    @Size(min=1,max = 50,message = "FirstName should be between 1 and 50")
    @NotEmpty(message = "FirstName should not be empty!")
    @Column(name = "first_name")
    private String firstName;

    @Size(min=2,max = 50,message = "LastName should be between 2 and 50")
    @NotEmpty(message = "LastName should not be empty!")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = "Position should not be empty!")
    private String position;

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Please provide a valid email address")
    @Column(unique = true)
    private String email;

    @Transient
    private Long departmentId;



    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Appointment> appointments=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,cascade = {DETACH,REFRESH,PERSIST,MERGE})
    private Hospital hospital;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {DETACH,REFRESH,PERSIST,MERGE})
    private List<Department> departments;

    public void addDepartment(Department department) {
        if (department==null){
            departments=new ArrayList<>();
        }
        departments.add(department);
    }
}
