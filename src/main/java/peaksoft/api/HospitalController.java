package peaksoft.api;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Hospital;
import peaksoft.service.HospitalService;
import java.util.List;

@Controller
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;
    @GetMapping
    String getAllHospital(Model model) {
        List<Hospital> hospitals = hospitalService.getAllHospital();
        model.addAttribute("hospitals", hospitals);
        return "hospital/hospitals";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("newHospital", new Hospital());
        return "hospital/newHospital";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("newHospital") Hospital hospital){
        hospitalService.save(hospital);
        return "redirect:/hospitals";
    }

    @DeleteMapping("{hospitalId}/delete")
    public String deleteHospital(@PathVariable("hospitalId") Long hospitalId){
        hospitalService.deleteHospitalById(hospitalId);
        return "redirect:/hospitals";
    }

    @GetMapping("{hospitalId}/edit")
    public String edit(@PathVariable("hospitalId") Long hospitalId, Model model){
        model.addAttribute("hospital", hospitalService.getHospitalById(hospitalId));
        return "hospital/update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,@ModelAttribute("hospital") Hospital hospital){
        hospitalService.updateHospital(id, hospital);
        return "redirect:/hospitals";
    }

}
