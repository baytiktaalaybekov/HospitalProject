package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_id_gen")
    @SequenceGenerator(name = "hospital_id_gen", sequenceName = "hospital_id_seq", allocationSize = 1)
    private Long id;

    @Size(min=2,max = 50,message="name should be between 2 and 50 characters!")
    @NotEmpty(message = "Name should not be empty!")
    private String name;

    @NotEmpty(message = "Address should not be empty")
    private String address;
    @Column(length = 10000)
    private String image;

    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)

    private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Patient> patients = new ArrayList<>();
    @OneToMany(mappedBy = "hospital", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Department> departments;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    public void setPatients(Patient patient) {
        if (patients == null) {
            patients = new ArrayList<>();
        } else {
            patients.add(patient);
        }
    }

    public void addDepartment(Department department) {
        if (departments == null) {
            departments = new ArrayList<>();
        }
        departments.add(department);
    }

    public void addAppointment(Appointment appointment1) {
        if (appointments == null){
            appointments=new ArrayList<>();
        }
        appointments.add(appointment1);
    }
}
