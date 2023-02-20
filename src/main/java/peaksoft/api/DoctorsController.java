package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Doctor;
import peaksoft.entities.Hospital;
import peaksoft.repository.DoctorsRepository;
import peaksoft.service.DoctorsService;

import java.util.List;
//
//@Controller
//@RequestMapping("/doctors")
//@RequiredArgsConstructor
public class DoctorsController {
//    private final DoctorsService doctorsService;
//    @GetMapping
//    String getAllDoctor(Model model){
//        List<Doctor> doctors = doctorsService.getAllDoctor();
//        model.addAttribute("doctors",doctors);
//        return "doctor/doctors";
//    }
//    @PostMapping("/new")
//    String create(@ModelAttribute("newDoctor") Doctor doctor){
//        doctorsService.saveDoctor(doctor);
//        return "redirect:/doctors";
//    }
//    @GetMapping("/saveDoctor")
//    String save(Model model){
//        model.addAttribute("doctor",new Doctor());
//        return "doctor/saveDoctor";
//    }
//    @DeleteMapping("{doctorId}/delete")
//    String deleteById(@PathVariable("doctorId") Long id) {
//        doctorsService.deleteDoctorById(id);
//        return "redirect:/doctors";
//    }

}
