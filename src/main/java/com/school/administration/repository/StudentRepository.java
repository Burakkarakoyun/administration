package com.school.administration.repository;

import com.school.administration.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
/*    List<Student> findByStudentNameAndStudentSurname(String studentName, String studentSurname);//basit kullanım


    @Query(value = "select s from Student s where s.studentName = :name and  s.studentSurname = :surname")
        //direkt sorgu yazılabilir.
        // @Query(value = "select s from Student s where s.studentName = :name and  s.studentSurname = :surname",
        // nativeQuery = true)
    List<Student> findByStudentNameAndStudentSurname1(@Param("name") String studentName,
                                                      @Param("surname") String studentSurname);//basit kullanım
*/
}
