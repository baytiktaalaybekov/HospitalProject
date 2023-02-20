package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Getter@Setter
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hospital_id_gen")
    @SequenceGenerator(name = "hospital_id_gen",sequenceName = "hospital_id_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    private String image;

    @OneToMany (mappedBy = "hospital",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
//
    private List<Doctor> doctors=new ArrayList<>();

    @OneToMany(mappedBy = "hospital",fetch = FetchType.LAZY)
//
    private List<Patient> patients=new ArrayList<>();

    @OneToMany(mappedBy = "hospital",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private List<Department> departments=new ArrayList<>();
    public void addDepartment(Department department){
        departments.add(department);
    }

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private List<Appointment> appointments=new ArrayList<>();
}
