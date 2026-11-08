package com.university.repository;

import com.university.model.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    List<Department> findByName(String name);
    List<Department> findByNameContaining(String name);
    List<Department> findByNameStartingWith (String name);
    List<Department> findByNameIgnoreCase(String name);
    boolean existsByCode (String code);
    boolean existsByName (String name);
    List<Department> findByCode (String code);
    List<Department> findByNameContainingIgnoreCase(String name);
    List<Department> findAllByOrderByNameAsc ();
    long countByNameContaining(String name);
    @Query("select d from Department d where d.name =:name")
    List<Department> getDepartmentByName(@Param("name")String name);
    @Query("select d from Department d where d.name like concat(:name  ,'%')")
    List<Department> getDepartmentsByNameStartingWith(@Param("name")String name);
    @Query("select d from Department d where d.description like concat('%', :description , '%') ")
    List<Department> getDepartmentsByDescriptionContaining(@Param("description")String description);
    @Query("select d from Department d where d.name =:name or d.description =:description")
    List<Department> getDepartmentByOr(@Param("name")String name,
                                       @Param("description")String description);
    @Query("select d from Department d  order by d.name ASC")
    List<Department> getDepartmentsByNameASC();
    @Query("select count(d)  from Department d where d.description like concat('%',:description ,'%')  ")
    long  getDepartmentsByCount(@Param("description") String description);

    //---------
    @Query(value = "select * from Departments where name = :name",nativeQuery = true)
    List<Department> getDepartmentsByName(@Param("name")String name);
    @Query(value = "select * from Departments where name like concat('%' , :name , '%')",nativeQuery = true)
    List<Department> getDepartmentsByNameContaining(@Param("name")String name);
    @Query(value = "select * from Departments where code!= :code",nativeQuery = true)
    List<Department> getDepartmentsByCodeNot(@Param("code")String code);
    @Query(value = "select * from Departments order by name DESC",nativeQuery = true)
    List<Department> getDepartmentsOrderByNameDesc();
    @Query(value = "select count(*) from Departments where code = :code",nativeQuery = true)
    long countDepartmentsByCode(@Param("code")String code);
    @Query(value = "select code ,count(*) from Departments group by  code ",nativeQuery = true)
    List<Object[]> countDepartmentsGroupByCode();


}
