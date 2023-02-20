package peaksoft.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Department;
import peaksoft.entities.Hospital;
import peaksoft.service.DepartmentService;
import peaksoft.service.HospitalService;
//
import java.util.List;

@Controller
@RequestMapping("/{id}/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final HospitalService hospitalService;

//    @GetMapping
//    String getAllDepartment(Model model) {
//        List<Department> departments = departmentService.getAllDepartment();
//        model.addAttribute("department", departments);
//        return "department/departments";
//    }
//
//    @PostMapping("/save")
//    String save(@ModelAttribute("newDepartment") Department department, @RequestParam("hospitalId") Long id) {
//        departmentService.saveDepartment(id, department);
//        return "department/departments";
//    }
//
//    @GetMapping("/new/{hospitalId}")
//    String newAdd(@PathVariable("hospitalId") Long hospitalId, Model model) {
//        model.addAttribute("newDepartment", new Department());
//        model.addAttribute("hospitalsId", hospitalId);
//        return "re";


//    @DeleteMapping("{departmentId}/delete")
//    String deleteById(@PathVariable("departmentId") Long id) {
//        departmentService.deleteDepartmentById(id);
//        return "redirect:/departments";
//    }


//public class DepartmentController {
//    private  final DepartmentService departmentService;
//    private  final HospitalService hospitalService;
//    private Long hospitalId;
//
//
//    @Autowired
//    public DepartmentController(DepartmentService departmentService, HospitalService hospitalService) {
//        this.departmentService = departmentService;
//        this.hospitalService = hospitalService;
//    }


    @GetMapping
    String getAllDepartment(Model model, @PathVariable("id") Long id) {
        model.addAttribute("departments", departmentService.getAllDepartment(id));

        return "department/departments";
    }
    @GetMapping("/newDepartment")
    String  newDepartment(Model model,@PathVariable("id")Long id ){
        model.addAttribute("newDepartment", new Department());
        return "department/newDepartment";
    }
    @PostMapping("/saveDepartment")
    String saveDepartment(@PathVariable("id") Long id,
                          @ModelAttribute("department") Department department){
        departmentService.saveDepartment(id, department);
        return "redirect:/{id}/departments";
    }

}


//
//
//    @GetMapping("/{hospitalId}")
//    String  getAll(Model model,@PathVariable("hospitalId")Long id ){
//        model.addAttribute("id",id);
//        model.addAttribute("departments", departmentService.getAll(id));
//        model.addAttribute("hospital",hospitalService.getById(id));
//        hospitalId=id;
//
//
//        return "department/departments";
//    }
//    @GetMapping("/addDepartment/{hospitalId}")
//    String addDepartment(@PathVariable("hospitalId") Long id ,Model model){
//        System.out.println("hello");
//        model.addAttribute("newDepartment",new Department());
//        model.addAttribute("hospitalId",id);
//        model.addAttribute("hospital",hospitalService.getById(id));
//        return "department/save";
//    }
//    @PostMapping("/saveDepartment/{hospitalId}")
//    String saveDepartment( @PathVariable("hospitalId")Long id,@ModelAttribute("department")Department department){
//        departmentService.save(id,department);
//        return "redirect:/departments/"+id;
//    }
//    @DeleteMapping("/deleteDepartment/{departmentId}")
//    String deleteHospital(@PathVariable("departmentId") Long id) {
//        departmentService.deleteById(id);
////        return "redirect:/departments/"+hospitalId;
//    }
//
//}
