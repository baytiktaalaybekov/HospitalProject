package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Appointment;
import peaksoft.service.AppointmentsService;
import peaksoft.service.DepartmentService;
import peaksoft.service.DoctorsService;
import peaksoft.service.PatientsService;

import java.util.List;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentsController {
    private final AppointmentsService appointmentsService;
    private final PatientsService patientsService;
    private final DoctorsService doctorsService;
    private final DepartmentService departmentService;

    @GetMapping("/{hospitalId}")
    String getAllAppointments(Model model,@PathVariable("hospitalId")Long hospitalId){
        model.addAttribute("appointments",appointmentsService.getAllAppointment(hospitalId));
        return "appointment/appointments";
    }
    @GetMapping("/new/{hospitalId}")
    String create(@PathVariable("hospitalId")Long hospitalId,Model model) {
        model.addAttribute("newAppointments", new Appointment());
        model.addAttribute("patients", patientsService.getAllPatient(hospitalId));
        model.addAttribute("departments", departmentService.getAllDepartment(hospitalId));
        model.addAttribute("doctors", doctorsService.getAllDoctor(hospitalId));
        model.addAttribute("hospitalId",hospitalId);
        return "appointment/newAppointment";


    }
        @PostMapping("/save/{hospitalId}")
        String save(@PathVariable("hospitalId")Long hospitalId,@ModelAttribute("newAppointments") Appointment appointment){
        appointmentsService.saveAppointment(hospitalId,appointment);
        return "redirect:/appointments/"+hospitalId;
        }

    @GetMapping("/edit/{appointmentId}")
    public String edit(@PathVariable("appointmentId") Long appointmentId, Model model){
        Appointment appointment = appointmentsService.getAppointmentById(appointmentId);
        model.addAttribute("appointment", appointmentsService.getAppointmentById(appointmentId));
        model.addAttribute("hospitalId", appointment.getDoctor().getHospital().getId());
        return "appointment/updateAppointment";
    }
    @PutMapping("/{hospitalId}/{appointmentId}/update")
    public String update(@ModelAttribute("appointment")Appointment appointment,
                         @PathVariable("appointmentId")Long appointmentId,
                         @PathVariable("hospitalId")Long hospitalId){
        appointmentsService.updateAppointment(appointmentId, appointment);
        return "redirect:/appointments/" + hospitalId;
    }

    @DeleteMapping("/{hospitalId}/{appointmentId}/delete")
    public String deleteDoctor(@PathVariable("appointmentId")Long appointmentId,
                               @PathVariable("hospitalId")Long hospitalId){
        appointmentsService.deleteAppointmentById(appointmentId,hospitalId);
        return"redirect:/appointments/" + hospitalId;
    }




//
//    @DeleteMapping("/{hospitalId}/{appointmentId}/delete")
//    public String deleteDoctor(@PathVariable("appointmentId")Long appointmentId,
//                               @PathVariable("hospitalId")Long hospitalId){
//        appointmentsService.deleteAppointmentById(appointmentId);
//        return"redirect:/appointments/" + hospitalId;
//    }



    }



