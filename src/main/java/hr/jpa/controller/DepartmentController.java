package hr.jpa.controller;

import hr.jpa.entity.Department;
import hr.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findall")
    public List<Department> findall(){
        return departmentService.findall();
    }
    @GetMapping("/findbyid/{id}")
    public Optional<Department> findById(@PathVariable int id){
        return departmentService.findById(id);
    }

    @PostMapping("/post")
    public Department insert(@RequestBody Department department){
        return departmentService.insert(department);
    }


    @PutMapping("/put")
    public Department update(@RequestBody Department department){

        return departmentService.update(department);

    }

}
