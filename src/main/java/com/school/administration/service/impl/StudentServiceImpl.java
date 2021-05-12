package com.school.administration.service.impl;

import com.school.administration.entities.Student;
import com.school.administration.exception.ObjectNotFoundException;
import com.school.administration.mapper.StudentMapper;
import com.school.administration.repository.StudentRepository;
import com.school.administration.request.StudentAddRequest;
import com.school.administration.request.StudentUpdateRequest;
import com.school.administration.response.StudentResponse;
import com.school.administration.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponse> listAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = studentMapper.toStudentResponseList(students);

        return studentResponses;
    }
    @Override
    public StudentResponse save(StudentAddRequest studentAddRequest) {
        Student student = studentMapper.toStudent(studentAddRequest);
        Student saved = studentRepository.save(student);
        return studentMapper.toStudentResponse(saved);
    }
    @Override
    public StudentResponse update( StudentUpdateRequest studentUpdateRequest) {
        Optional<Student> student = studentRepository.findById(studentUpdateRequest.getStudentId());
        if(student.isPresent()){
            BeanUtils.copyProperties(studentUpdateRequest,student.get());
            Student savedStudent = studentRepository.save(student.get());
            return  studentMapper.toStudentResponse(savedStudent);
        }
        else {
            throw new ObjectNotFoundException("Kullanıcı Bulunamadı.");
        }
    }
    @Override
    public void delete(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);

        if (student.isPresent()) {
            student.get().setEndDate(LocalDate.now());
            studentRepository.save(student.get());
        }

    }
}
