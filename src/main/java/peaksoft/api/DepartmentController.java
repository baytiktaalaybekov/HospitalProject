package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Department;
import peaksoft.entities.Doctor;
import peaksoft.entities.Hospital;
import peaksoft.service.DepartmentService;
import peaksoft.service.DoctorsService;
import peaksoft.service.HospitalService;

import java.util.List;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final HospitalService hospitalService;
    private final DoctorsService doctorsService;


    @GetMapping("/{id}")
    public String getAllDepartments(Model model,
                                    @PathVariable("id") Long id ,
                                    @ModelAttribute("doctor") Doctor doctor ){
        model.addAttribute("departments", departmentService.getAllDepartment(id));
        model.addAttribute("doctors", doctorsService.getAllDoctor(id));
        model.addAttribute("hospitalId",id);
        return "department/departments";
    }

    @PostMapping("/save/{hospitalId}")
    public String save(@ModelAttribute("newDepartment") Department department,
                       @PathVariable Long hospitalId) {
        departmentService.saveDepartment(hospitalId, department);
        return "redirect:/departments/"+hospitalId;
    }

    @GetMapping("/new/{id}")
    public String create(Model model,
                         @PathVariable("id")Long id) {
        model.addAttribute("newDepartment", new Department());
        model.addAttribute("hospitalId", id);
        return "/department/newDepartment";
    }











    @GetMapping("/edit/{departmentId}")
    public String edit(@PathVariable("departmentId")Long departmentId,
                       Model model){
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("department", department);
        model.addAttribute("hospitalId",department.getHospital().getId());
        return "/department/update";
    }

    @PostMapping("/{hospitalId}/{departmentId}/update")
    public String update(@ModelAttribute("department") Department department,
                         @PathVariable("departmentId") Long departmentId,
                         @PathVariable("hospitalId") Long hospitalId){
        departmentService.updateDepartment(departmentId,department);
        return "redirect:/departments/" + hospitalId;
    }




    @DeleteMapping("/{hospitalId}/{departmentId}/delete")
    public String deletePatient(@PathVariable("departmentId")Long id,
                                @PathVariable("hospitalId")Long hospitalId){
        departmentService.deleteDepartmentById(id);
        return"redirect:/departments/" + hospitalId;
    }

}











//    @GetMapping("/{id}")
//    String getAllDepartment(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("departments", departmentService.getAllDepartment(id));
//        return "department/departments";
//    }
//    @PostMapping("/saveDepartment")
//    String save(@PathVariable("id") Long id,
//                          @ModelAttribute("department") Department department){
//        departmentService.saveDepartment(id, department);
//        return "department/departments";
//    }
//    @GetMapping("/saveDepartment/departmentId")
//    String save(Model model,@PathVariable("departmentId")Long id){
//        model.addAttribute("department",new Department());
//        model.addAttribute("hospitalId",id);
//        return "/department/newDepartment";


//    @PostMapping("/new")
//    String create(@ModelAttribute("department")Department department, @PathVariable("id") Long id) {
//        departmentService.saveDepartment(id,department);
//        return "redirect:/{id}/departments";
//    }







//    @GetMapping ("{departmentId}/edit")
//    String edit(@PathVariable("departmentId") Long departmentId,Model model) {
//        model.addAttribute("department", departmentService.getDepartmentById(departmentId));
//        return "department/update";
//    }
//        @PostMapping("{id}/update")
//                String update(@PathVariable("id") Long id,@ModelAttribute("department")Department department){
//            departmentService.updateDepartment(id,department);
//            return "redirect:/departments";
//        }



