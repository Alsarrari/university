package com.university.repository;

import com.university.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    boolean existsByEmail(String email);
    List<Student> findByAge(Integer age);
    List<Student> findByNameContaining(String name);
    boolean existsByName(String name);
    long countByAge(Integer age);
    List<Student> findByName(String name);
    //----------
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeLessThan(Integer age);
    //-----------
    List<Student> findByNameStartingWith(String name);
    //---------
    List<Student> findAllByOrderByAgeAsc();
    List<Student> findAllByOrderByAgeDesc();
    List<Student> findByAgeBetween(Integer minAge,Integer maxAge);
    List<Student> findByAgeIn(Collection<Integer> ages);
    List<Student> findByNameIgnoreCase (String name);
    @Query("Select s from Student s where s.age > :age " )
    List<Student> findStudentsOlderThan(@Param("age") Integer age);
    @Query("select s from Student s where s.age > :age and s.name = :name")
    List<Student> findStudentsByAgeAndName(@Param("age") Integer age , @Param("name") String name);
    @Query("select s from Student s where s.age > :age or s.name = :name ")
    List<Student> findStudentsByAgeOrName (@Param("age") Integer age,@Param("name") String name);
    @Query("select s from Student s where s.name like concat(:name , '%')")
    List<Student> findStudentsByNameLike(@Param("name") String name);
    @Query("select s from Student s  order by s.age asc  ")
    List<Student> findStudentsOrderByAge();
    @Query("select max (s.age) from Student s ")
    Integer findMaxAge();
    @Query("select avg(s.age) from Student s")
    double findAverageAge();
    @Query("select min(s.age) from Student s")
    Integer findMinAge();
    @Query("select count(s) from Student s")
    long countAllStudents();
    @Query("select sum(s.age) from Student s")
    Long sumAllStudentAges();
    @Query("select distinct(s.age) from Student s ")
    List<Integer> findDistinctAges();
    @Query("select s.age , count (s) from Student s group by s.age ")
    List<Object[]> countStudentsByAge();
    @Query("select s from Student s where s.age between :minAge and :maxAge")
    List<Student> getStudentsAgeBetween(@Param("minAge")Integer minAge,
                                   @Param("maxAge")Integer maxAge);
    @Query("select s from Student s where s.age >:age and s.name like concat(:name,'%') ")
    List<Student> getStudentsByNameAndAge(@Param("age")Integer age,
                                          @Param("name")String name);
    @Query("select s from Student s where s.age < :minAge or s.age > :maxAge")
    List<Student> getStudentsAgeByOr(@Param("minAge")Integer minAge,
                                     @Param("maxAge")Integer maxAge);

    //---------
    @Query(value = "select * from Students  where age > :age  ", nativeQuery = true )
    List<Student> getAllStudentsByAge(@Param("age")Integer age);
    @Query(value = "select * from Students where age > :age and name like concat(:name , '%' )", nativeQuery = true)
    List<Student> getStudentsByAgeAndByName(@Param("age")Integer age,
                                            @Param("name")String name);
    @Query(value = "select * from Students where age< :minAge or age > :maxAge ",nativeQuery = true)
    List<Student> getStudentsBaAgee(@Param("minAge")Integer minAge,
                                    @Param("maxAge")Integer maxAge);
    @Query(value = "select * from Students where name like concat('%', :name,'%')" , nativeQuery = true)
    List<Student> getStudentsss(@Param("name")String name);
    @Query(value = "select * from Students order by age DESC , name ASC",nativeQuery = true)
    List<Student> getStudentsASC();
    @Query(value = "select count(*) from Students where age > :age",nativeQuery = true)
    long countStudents(@Param("age")Integer age);
    @Query(value = "select sum(age) from Students where age > 25 ",nativeQuery = true)
    long sumStudents();
    @Query(value = "select DISTINCT  age from Students order by age ASC  ",nativeQuery = true)
    List<Student> getStudentsDistinct();
}
