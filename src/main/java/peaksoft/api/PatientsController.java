package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Hospital;
import peaksoft.entities.Patient;
import peaksoft.service.PatientsService;

import java.util.List;

//@Controller
//@RequestMapping("/patients")
//@RequiredArgsConstructor
public class PatientsController {

//    private final PatientsService patientsService;
//
//    @GetMapping
//    String getAllPatient(Model model) {
//        List<Patient> patients = patientsService.getAllPatient();
//        model.addAttribute("patients", patients);
//        return "patient/patients";
//    }
//    @PostMapping("/new")
//    String create(@ModelAttribute("newPatient")Patient patient){
//        patientsService.save(patient);
//        return "redirect:/patients";
//    }
//    @GetMapping("/savePatient")
//    String save(Model model){
//        model.addAttribute("patient",new Patient());
//        return "patient/patients";
//    }
//    @DeleteMapping("{patientId}/delete")
//    String deleteById(@PathVariable("patientId") Long id) {
//        patientsService.deletePatientById(id);
//        return "redirect:/patients";
//    }


}
