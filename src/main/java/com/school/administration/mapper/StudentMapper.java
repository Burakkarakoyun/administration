package com.school.administration.mapper;

import com.school.administration.entities.Student;
import com.school.administration.request.StudentAddRequest;
import com.school.administration.response.StudentResponse;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<StudentResponse> toStudentResponseList (List<Student> students);
    StudentResponse toStudentResponse (Student student);
    Student toStudent (StudentAddRequest studentAddRequest);
}
