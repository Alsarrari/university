package com.university.controller;

import com.university.api.ApiResponse;
import com.university.model.entity.Student;
import com.university.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addStudent(@Valid @RequestBody Student student){
       Student addStudent=  studentService.addStudent(student);
         return ResponseEntity.status(HttpStatus.CREATED)
                 .body(new ApiResponse("Student added successfully",addStudent));
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ApiResponse> getStudentById(@PathVariable Integer id){
       Student studentId=  studentService.getStudentById(id);
         return ResponseEntity.status(HttpStatus.OK)
                 .body(new ApiResponse("student successfully",studentId));
    }
    @GetMapping("/get-all-students")
    public ResponseEntity<ApiResponse> getAllStudents(){
        List<Student> students=studentService.getAllStudents();

         return ResponseEntity.status(HttpStatus.OK)
                 .body(new ApiResponse("Students retrieved successfully",students));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable Integer id,
                                @Valid @RequestBody Student student){
       Student updateStudent=  studentService.updateStudent(id, student);
       return ResponseEntity.status(HttpStatus.OK)
               .body(new ApiResponse("student updated successfully",updateStudent));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable Integer id){
     studentService.deleteStudent(id);

       return ResponseEntity.status(HttpStatus.OK)
               .body(new ApiResponse("student deleted successfully",null));
    }
    @GetMapping("/search-age")
    public ResponseEntity<ApiResponse> getByAge(@RequestParam Integer age){

      List<Student> search = studentService.findByAge(age);
      return ResponseEntity.status(HttpStatus.OK)
              .body(new ApiResponse("Students retrieved successfully",search));
    }
    @GetMapping("/containing-name")
    public ResponseEntity<ApiResponse> getByName(@RequestParam String name){
        List<Student> containing= studentService.findByNameContaining(name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("Students retrieved successfully",containing));
    }
    @GetMapping("/exists-name")
    public ResponseEntity<ApiResponse> existsByName (@RequestParam String name){
        boolean exists= studentService.existsByName(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",exists));
    }
    @GetMapping("/count-age")
    public ResponseEntity<ApiResponse> countByAge(@RequestParam Integer age){
        long count= studentService.countByAge(age);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",count));
    }
    @GetMapping("/get-by-name")
    public ResponseEntity<ApiResponse> getName(@RequestParam String name){
        List<Student> searchNAme= studentService.getName(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",searchNAme));
    }
    @GetMapping("/get-greater-than")
    public ResponseEntity<ApiResponse> findByGreaterThan(@RequestParam Integer age){
        List<Student> greater=studentService.findByGreaterThan(age);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",greater));
    }
    @GetMapping("/get-less-than")
    public ResponseEntity<ApiResponse> findByLessThan(@RequestParam Integer age){
        List<Student> less=studentService.findByLessThan(age);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",less));
    }
    @GetMapping("/get-starting-with")
   public ResponseEntity<ApiResponse> findByStartingWith(@RequestParam String name){
        List<Student> starting=studentService.findByStartingWith(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",starting));
    }
    @GetMapping("/get-asc")
    public ResponseEntity<ApiResponse> findByAsc(){
        List<Student> asc=studentService.orderByAsc();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",asc));
    }
    @GetMapping("/get-desc")
    public ResponseEntity<ApiResponse> findByDesc(){
        List<Student> desc=studentService.orderByDesc();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",desc));
    }
    @GetMapping("/get-age-between")
    public ResponseEntity<ApiResponse> findAgeByBetween(@RequestParam Integer minAge,
                                                        @RequestParam Integer maxAge){
        List<Student> ageBetween=studentService.findByAgeBetween(minAge, maxAge);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",ageBetween));
    }
    @GetMapping("/Collection")
    public ResponseEntity<ApiResponse> findByAgeIn(@RequestParam List<Integer> ages){
        List<Student> collection=studentService.findByAgeIn(ages);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",collection));
    }
    @GetMapping("/findByNameIgnoreCase")
    public ResponseEntity<ApiResponse> findByNameIgnoreCase(@RequestParam String name ){
        List<Student> names= studentService.findByNameIgnoreCase(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",names));
    }
    @GetMapping("/older-than")
    public ResponseEntity<ApiResponse> findStudentsOlderThan(@RequestParam Integer age){
        List<Student> older=studentService.findStudentsOlderThan(age);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",older));
    }
    @GetMapping("/name-and-age")
    public ResponseEntity<ApiResponse> findStudentsByAgeAndName(@RequestParam Integer age,
                                                                @RequestParam String name){
        List<Student> nameAndAge=studentService.findStudentsByAgeAndName(age, name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",nameAndAge));
    }
    @GetMapping("/name-or-age")
    public ResponseEntity<ApiResponse> findStudentsByAgeOrName (@RequestParam Integer age,
                                                                @RequestParam String name){
        List<Student> ageOrName = studentService.findStudentsByAgeOrName(age, name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",ageOrName));
    }
    @GetMapping("/like-name")
    public ResponseEntity<ApiResponse> findStudentsByNameLike(@RequestParam String name ){
        List<Student> likeNAme=studentService.findStudentsByNameLike(name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",likeNAme));
    }
    @GetMapping("/order-by-asc")
    public ResponseEntity<ApiResponse> findStudentsOrderByAge(){
        List<Student> orderByAsc=studentService.findStudentsOrderByAge();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",orderByAsc));
    }
    @GetMapping("/max-age")
    public ResponseEntity<ApiResponse> findMaxAge(){
      Integer maxAge=  studentService.findMaxAge();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",maxAge));
    }
    @GetMapping("/avg-age")
    public ResponseEntity<ApiResponse> findAverageAge(){
        double avg=studentService.findAverageAge();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",avg));
    }
    @GetMapping("/min-age")
    public ResponseEntity<ApiResponse> findMinAge(){
        Integer min=studentService.findMinAge();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",min));
    }
    @GetMapping("/count-students")
    public ResponseEntity<ApiResponse> countAllStudents(){
        long count =studentService.countAllStudents();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",count));
    }
    @GetMapping("/sum-ages")
    public ResponseEntity<ApiResponse> sumAllStudentAges(){
        Long sum=studentService.sumAllStudentAges();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",sum));
    }
    @GetMapping("/distinct")
    public ResponseEntity<ApiResponse> findDistinctAges(){
        List<Integer> distinct=studentService.findDistinctAges();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",distinct));
    }
    @GetMapping("/counts-students")
    public ResponseEntity<ApiResponse> countStudentsByAge(){
        List<Object[]> counts=studentService.countStudentsByAge();
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",counts));
    }
    @GetMapping("/age-between")
    public ResponseEntity<ApiResponse> getStudentsAgeBetween(@RequestParam Integer minAge,
                                                             @RequestParam Integer maxAge){
        List<Student> between=studentService.getStudentsAgeBetween(minAge, maxAge);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",between));
    }
    @GetMapping("/age-and-name")
    public ResponseEntity<ApiResponse> getStudentsByNameAndAge(@RequestParam Integer age,
                                                               @RequestParam String name){
        List<Student> ageAndName=studentService.getStudentsByNameAndAge(age, name);
        return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",ageAndName));
    }
    @GetMapping("/age-or")
    public ResponseEntity<ApiResponse> getStudentsAgeByOr(@RequestParam Integer minAge,
                                                          @RequestParam Integer maxAge){
        List<Student> ageOr=studentService.getStudentsAgeByOr(minAge, maxAge);
       return ResponseEntity.ok()
                .body(new ApiResponse("Students retrieved successfully",ageOr));
    }
    @GetMapping("/page")
    public Page<Student> getStudentsByPage(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size){
        return studentService.getStudentsByPage(page, size);
    }
    @GetMapping("/page-desc")
    public Page<Student> getStudentsByPageDESC(@RequestParam(defaultValue = "0")int page,
                                               @RequestParam(defaultValue = "10")int size){
        return studentService.getStudentsByPageDESC(page, size);
    }
    @GetMapping("/page-auto")
    public Page<Student> getStudentsByPageAuto(@RequestParam(defaultValue = "0")int page,
                                               @RequestParam(defaultValue = "10")int size,
                                               @RequestParam(defaultValue = "DESC")String direction){
        return studentService.getStudentsByPageAuto(page,size,direction);
    }




}
