package com.university.service;
import com.university.exception.ResourceNotFoundException;
import com.university.model.entity.Department;
import com.university.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepo departmentRepo;
    public Department addDepartment(Department department){
        return departmentRepo.save(department);
    }
    public Department getDepartmentById(Integer id){

        return departmentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Department not found"));
    }
    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }
    public  Department updateDepartment(Integer id , Department department){
        Department department1=departmentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department not found"));
        department1.setCode(department.getCode());
        department1.setName(department.getName());
        department1.setDescription(department.getDescription());
        return departmentRepo.save(department1);
    }
    public void deleteDepartment(Integer id){
        departmentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department not found"));
        departmentRepo.deleteById(id);
    }
    public List<Department> findByName(String name){
        return departmentRepo.findByName(name);
    }
    public List<Department> findByNameContaining(String name){
        return departmentRepo.findByNameContaining(name);
    }
    public List<Department> findByNameStartingWith(String name){
        return departmentRepo.findByNameStartingWith(name);
    }
    public List<Department> findByNameIgnoreCase(String name){
         return departmentRepo.findByNameIgnoreCase(name);
    }
    public boolean existsByCode(String code){
        return departmentRepo.existsByCode(code);
    }
    public boolean existsByName(String name){
        return departmentRepo.existsByName(name);
    }
    public List<Department> findByCode (String code){
        return departmentRepo.findByCode(code);
    }
    public List<Department> findByNameContainingIgnoreCase(String name){
        return departmentRepo.findByNameContainingIgnoreCase(name);
    }
    public List<Department> findAllByOrderByNameAsc (){
        return departmentRepo.findAllByOrderByNameAsc();
    }
    public long findCountByNameContaining(String name) {
        return departmentRepo.countByNameContaining(name);
    }
    public List<Department> getDepartmentByName(String name){
        return departmentRepo.getDepartmentByName(name);
    }
    public List<Department> getDepartmentsByNameStartingWith(String name){
        return departmentRepo.getDepartmentsByNameStartingWith(name);
    }
    public List<Department> getDepartmentsByDescriptionContaining(String description){
        return departmentRepo.getDepartmentsByDescriptionContaining(description);
    }
    public List<Department> getDepartmentByOr(String name,String description){
        return departmentRepo.getDepartmentByOr(name, description);
    }
    public List<Department> getDepartmentsByNameASC(){
        return departmentRepo.getDepartmentsByNameASC();
    }
    public long getDepartmentsByCount(String description){
        return departmentRepo.getDepartmentsByCount(description);
    }

}
