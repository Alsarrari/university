package com.university.service;

import com.university.exception.DuplicateEmailException;
import com.university.exception.ResourceNotFoundException;
import com.university.model.entity.Student;
import com.university.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Internal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public Student addStudent(Student student){
       if (studentRepo.existsByEmail(student.getEmail())){
            throw new  DuplicateEmailException("Email already exists");
       }
        return studentRepo.save(student);

    }
    public Student getStudentById(Integer id ){
        return studentRepo.findById(id)
                 .orElseThrow(()->new ResourceNotFoundException("the student not found"));

    }
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    public Student updateStudent(Integer id , Student student ){
        Student student1= studentRepo.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("the student not found"));
         student1.setAge(student.getAge());
         student1.setName(student.getName());
         student1.setEmail(student.getEmail());

        return studentRepo.save(student1);
    }
    public void deleteStudent(Integer id){
        studentRepo.findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("the student not found"));
          studentRepo.deleteById(id);

    }
    public List<Student> findByAge(Integer age){
       return studentRepo.findByAge(age);
    }
    public List<Student> findByNameContaining(String name){
        return studentRepo.findByNameContaining(name);
    }
    public boolean existsByName(String name){
       return studentRepo.existsByName(name);
    }
    public long countByAge(Integer age){
        return studentRepo.countByAge(age);
    }
    public List<Student> getName(String name){
        return studentRepo.findByName(name);
    }
    public List<Student> findByGreaterThan(Integer age){
        return studentRepo.findByAgeGreaterThan(age);
    }
    public List<Student> findByLessThan(Integer age){
        return studentRepo.findByAgeLessThan(age);
    }
    public List<Student> findByStartingWith(String name){
        return studentRepo.findByNameStartingWith(name);
    }
    public List<Student> orderByAsc(){
        return studentRepo.findAllByOrderByAgeAsc();
    }
    public List<Student> orderByDesc(){
        return studentRepo.findAllByOrderByAgeDesc();
    }
    public List<Student> findByAgeBetween(Integer minAge , Integer maxAge){
        return studentRepo.findByAgeBetween(minAge, maxAge);
    }
    public List<Student> findByAgeIn(List<Integer> ages){
        return studentRepo.findByAgeIn(ages);
    }
    public List<Student> findByNameIgnoreCase(String name ){
        return studentRepo.findByNameIgnoreCase(name);
    }
    public List<Student> findStudentsOlderThan(Integer age){
        return studentRepo.findStudentsOlderThan(age);
    }
    public List<Student> findStudentsByAgeAndName(Integer age , String name){
        return studentRepo.findStudentsByAgeAndName(age, name);
    }
    public List<Student> findStudentsByAgeOrName (Integer age , String name){
        return studentRepo.findStudentsByAgeOrName(age, name);
    }
    public List<Student> findStudentsByNameLike(String name ){
        return studentRepo.findStudentsByNameLike(name);
    }
    public List<Student> findStudentsOrderByAge(){
        return studentRepo.findStudentsOrderByAge();
    }
    public Integer findMaxAge(){
        return studentRepo.findMaxAge();
    }
    public double findAverageAge(){
        return studentRepo.findAverageAge();
    }
    public Integer findMinAge(){
        return studentRepo.findMinAge();
    }
    public long countAllStudents(){
        return studentRepo.countAllStudents();
    }
    public Long sumAllStudentAges(){
        return studentRepo.sumAllStudentAges();
    }
    public List<Integer> findDistinctAges(){
        return studentRepo.findDistinctAges();
    }
    public List<Object[]> countStudentsByAge(){
        return studentRepo.countStudentsByAge();
    }
    public List<Student> getStudentsAgeBetween(Integer minAge , Integer maxAge){
        return studentRepo.getStudentsAgeBetween(minAge, maxAge);
    }
    public List<Student> getStudentsByNameAndAge(Integer age , String name){
        return studentRepo.getStudentsByNameAndAge(age,name);
    }
    public List<Student> getStudentsAgeByOr(Integer minAge,Integer maxAge){
        return studentRepo.getStudentsAgeByOr(minAge, maxAge);
    }

    public Page<Student> getStudentsByPage(int page ,int size){
        Pageable pageable = PageRequest.of(page, size);
        return studentRepo.findAll(pageable);
    }
    public Page<Student> getStudentsByPageDESC(int page, int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,"age"));
        return studentRepo.findAll(pageable);
    }
    public Page<Student> getStudentsByPageAuto(int page, int size, String direction) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.valueOf(direction), "age")
        );

        return studentRepo.findAll(pageable);
    }
}
