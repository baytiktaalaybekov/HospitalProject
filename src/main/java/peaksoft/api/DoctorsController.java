package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Department;
import peaksoft.entities.Doctor;
import peaksoft.entities.Hospital;

import peaksoft.repository.DepartmentRepository;
import peaksoft.service.DoctorsService;

import javax.print.Doc;
import java.util.List;
//
@Controller
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorsController {
    private final DoctorsService doctorsService;
    private final DepartmentRepository departmentRepository;

    @GetMapping("/{Id}")
    public String getAllDoctor(Model model, @PathVariable("Id") Long id){
        model.addAttribute("doctors",doctorsService.getAllDoctor(id));
        model.addAttribute("hospitalId",id);
        return "/doctor/doctors";
    }


    @GetMapping("/new/{Id}")
    public String create(Model model, @PathVariable("Id") Long Id){
        model.addAttribute("newDoctor", new Doctor());
        model.addAttribute("hospitalId", Id);
        return "/doctor/newDoctor";
    }

    @PostMapping("/save/{hospitalId}")
    public String saveDoctor(@ModelAttribute("newDoctor")Doctor doctor,
                             @PathVariable("hospitalId") Long hospitalId){
        doctorsService.saveDoctor(hospitalId, doctor);
        return "redirect:/doctors/"+hospitalId;
    }



    @GetMapping("/edit/{doctorId}")
    public String edit(@PathVariable("doctorId")Long doctorId,
                       Model model){
        Doctor doctor = doctorsService.getByDoctorId(doctorId);
        model.addAttribute("doctor", doctor);
        model.addAttribute("hospitalId",doctor.getHospital().getId());
        return "/doctor/updateDoctor";
    }

    @PostMapping("/{hospitalId}/{doctorId}/update")
    public String update(@ModelAttribute("doctor") Doctor doctor,
                         @PathVariable("doctorId") Long doctorId,
                         @PathVariable("hospitalId") Long hospitalId){
        doctorsService.update(doctorId,doctor);
        return "redirect:/doctors/" + hospitalId;
    }

    @GetMapping("/delete/{doctorId}")
    String delete(@PathVariable Long doctorId){
        Long hospitalId = doctorsService.getByDoctorId(doctorId).getHospital().getId();
        doctorsService.deleteDoctorById(doctorId);
        return "redirect: /doctors/"+hospitalId;
    }

    @GetMapping("/{hospitalId}/{doctorId}/departments")
    String assignDoctor(@PathVariable("hospitalId") Long id,
                        @PathVariable("doctorId") Long doctorId,
                        Model model) {
        model.addAttribute("doctor", doctorsService.getByDoctorId(doctorId));
        model.addAttribute("departments", departmentRepository.getAllDepartment(id));
        return "doctor/departments";
    }
    @GetMapping("/{hospitalId}/{doctorId}/assignDepartment")
    String saveAssignDoctor(@PathVariable("hospitalId") Long id,
                            @PathVariable("doctorId") Long doctorId,
                            Model model){
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("departments", departmentRepository.getAllDepartment(id));
        return "doctor/newDepartment";
    }
    @PatchMapping("/{hospitalId}/{doctorId}/saveAssignDepartment")
    private String assignDoctor(@PathVariable("hospitalId") Long hospitalId,
                                @PathVariable("doctorId") Long doctorId,
                                @ModelAttribute("doctor")Doctor doctor) {
        doctorsService.assignDoctor(doctorId, doctor);
        return "redirect:/doctors/" + hospitalId;
    }






}