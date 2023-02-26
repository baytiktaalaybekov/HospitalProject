package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "departments")
@Getter@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_id_gen")
    @SequenceGenerator(name = "department_id_gen",sequenceName = "department_id_seq",allocationSize = 1)
    private Long id;
    @Size(min=2,max = 50,message = "Name should be between 2 and 50 characters!")
    private String name;
    @ManyToMany(mappedBy = "departments",fetch = FetchType.LAZY,cascade = {REFRESH,PERSIST,MERGE,DETACH})
     List<Doctor> doctors=new ArrayList<>();

    @ManyToOne(cascade ={REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST} )
    private Hospital hospital;


    public void addDoctor(Doctor doctor) {
        if (doctors==null){
            doctors=new ArrayList<>();
        }
        doctors.add(doctor);
    }
}
