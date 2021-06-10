package com.school.administration.repository;

import com.school.administration.entities.StudentCourseRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRelRepository extends JpaRepository<StudentCourseRel, Integer> {
    //@Query(value = "select scr from StudentCourseRel scr where ")

}
