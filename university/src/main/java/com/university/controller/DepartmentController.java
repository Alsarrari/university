package com.university.controller;

import com.university.api.ApiResponse;
import com.university.model.entity.Department;
import com.university.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addDepartment(@Valid @RequestBody Department department){
        Department addDepartment=departmentService.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("Department added successfully",addDepartment));
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ApiResponse> getDepartmentById(@PathVariable Integer id){
        Department departmentId=departmentService.getDepartmentById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("Department successfully",departmentId));
    }
    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse> getAllDepartments(){
        List<Department> getDepartments=departmentService.getAllDepartments();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("Department successfully",getDepartments));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateDepartment(@PathVariable Integer id,
                                                           @Valid @RequestBody Department department){
        Department updatedepartment=departmentService.updateDepartment(id, department);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("Department updated successfully",updatedepartment));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("Department deleted successfully",null));
    }
    @GetMapping("/by-name")
    public ResponseEntity<ApiResponse> findByName(@RequestParam String name){
        List<Department> findName=departmentService.findByName(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",findName));
    }
    @GetMapping("/containing")
    public ResponseEntity<ApiResponse> findByNameContaining(@RequestParam String name){
        List<Department> containing=departmentService.findByNameContaining(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",containing));
    }
    @GetMapping("/name-starting-with")
    public ResponseEntity<ApiResponse> findByNameStartingWith(@RequestParam String name){
        List<Department>startingWith=departmentService.findByNameStartingWith(name);
       return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",startingWith));
    }
    @GetMapping("/name-ignore-case")
    public ResponseEntity<ApiResponse> findByNameIgnoreCase(@RequestParam String name){
        List<Department>nameIgnoreCase=departmentService.findByNameIgnoreCase(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",nameIgnoreCase));
    }
    @GetMapping("/exists-by-code")
    public ResponseEntity<ApiResponse> existsByCode(@RequestParam String code){
       boolean exist= departmentService.existsByCode(code);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",exist));
    }
    @GetMapping("/exists-by-name")
    public ResponseEntity<ApiResponse> existsByName(@RequestParam String name){
       boolean exists = departmentService.existsByName(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",exists));
    }
    @GetMapping("/find-by-code")
    public ResponseEntity<ApiResponse> findByCode(@RequestParam String code){
        List<Department> findByCode=departmentService.findByCode(code);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",findByCode));
    }
    @GetMapping("/name-containing-ignore-case")
    public ResponseEntity<ApiResponse> findByNameContainingIgnoreCase(@RequestParam String name){
     List<Department> ignore=   departmentService.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",ignore));
    }
    @GetMapping("/order-by-name-asc")
    public ResponseEntity<ApiResponse> orderByNameAsc(){
      List<Department> asc= departmentService.findAllByOrderByNameAsc();
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",asc));
    }
    @GetMapping("/count-by-name")
    public ResponseEntity<ApiResponse> findCountByNameContaining(@RequestParam String name){
        long count = departmentService.findCountByNameContaining(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Count retrieved successfully",count));
    }
    @GetMapping("/department-By-Name")
    public ResponseEntity<ApiResponse> getDepartmentByName(@RequestParam String name){
        List<Department> departmentByName=departmentService.getDepartmentByName(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",departmentByName));
    }
    @GetMapping("/startingWith")
    public ResponseEntity<ApiResponse> getDepartmentsByNameStartingWith(@RequestParam String name){
        List<Department> startingWith=departmentService.getDepartmentsByNameStartingWith(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",startingWith));
    }
    @GetMapping("/get-description")
    public ResponseEntity<ApiResponse> getDepartmentsByDescriptionContaining(@RequestParam String description){
        List<Department> getDescription=departmentService.getDepartmentsByDescriptionContaining(description);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",getDescription));
    }
    @GetMapping("/department-by-or")
    public ResponseEntity<ApiResponse> getDepartmentByOr(@RequestParam String name,
                                                         @RequestParam String description){
        List<Department> departmentByOr=departmentService.getDepartmentByOr(name, description);
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",departmentByOr));
    }
    @GetMapping("/name-ASC")
    public ResponseEntity<ApiResponse> getDepartmentsByNameASC(){
        List<Department> nameASC=departmentService.getDepartmentsByNameASC();
        return ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",nameASC));
    }
    @GetMapping("/description-by-count")
    public ResponseEntity<ApiResponse> getDepartmentsByCount(@RequestParam String description){
        long descriptionByCount=departmentService.getDepartmentsByCount(description);
      return   ResponseEntity.ok()
                .body(new ApiResponse("Department retrieved successfully",descriptionByCount));
    }

}
