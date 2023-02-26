package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "appointments")
@Getter@Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appointment_id_gen")
    @SequenceGenerator(name ="appointment_id_gen",sequenceName = "appointment_id_seq",allocationSize = 1)
    private Long id;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Department department;

    @Transient
    private Long doctorId;
    @Transient
    private Long departmentId;
    @Transient
    private Long patientId;


}
