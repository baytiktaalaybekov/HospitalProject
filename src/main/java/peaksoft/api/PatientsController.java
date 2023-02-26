package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Patient;
import peaksoft.enums.Gender;
import peaksoft.service.PatientsService;


import java.util.List;

@Controller
@RequestMapping("/{id}/patients")
@RequiredArgsConstructor
public class PatientsController {
    private final PatientsService patientsService;

    @GetMapping
    String getAllDepartments(@PathVariable("id") Long id,Model model){
        List<Patient> patients = patientsService.getAllPatient(id);
        model.addAttribute("patients",patients);
        model.addAttribute("hospitalId",id);
        return "patient/patients";
    }
    @GetMapping("/newPatient")
    String save(Model model,@PathVariable("id")Long id){
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospitalId",id);
        model.addAttribute("male", Gender.MALE.name());
        model.addAttribute("female", Gender.FEMALE.name());
        return "/patient/newPatient";
    }

    @PostMapping("/new")
    String create(@ModelAttribute("newPatient")Patient patient, @PathVariable("id") Long id) {
        patientsService.save(id,patient);
        return "redirect:/{id}/patients";
    }

@GetMapping("/edit/{patientId}")
    String edit(@PathVariable("patientId")Long patientId,Model model){
        Patient patient = patientsService.getPatientById(patientId);
        model.addAttribute("patient",patient);
        model.addAttribute("hospitalId",patient.getHospital().getId());
        model.addAttribute("female",Gender.FEMALE);
    model.addAttribute("male",Gender.FEMALE);
        return "patient/updatePatient";
}


@PostMapping("/{patientId}/updatePatient")
    String update(@ModelAttribute("patient")Patient patient,
                  @PathVariable("patientId")Long patientId){
    patientsService.updatePatient(patientId,patient);
    return "redirect:/{id}/patients";
    }

    @DeleteMapping("/{patientId}/delete")
    public String deletePatient(@PathVariable("patientId")Long patientId,
                                @PathVariable("id")Long id){
        patientsService.deletePatientById(patientId);
        return"redirect:/{id}/patients";
    }

}