package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_id_gen")
    @SequenceGenerator(name = "department_id_gen",sequenceName = "department_id_seq",allocationSize = 1)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "departments",fetch = FetchType.LAZY)
     List<Doctor> doctors=new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Hospital hospital;



}
