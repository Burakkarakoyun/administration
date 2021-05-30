package com.school.administration.service.impl;
import com.school.administration.entities.StudentCourseRel;
import com.school.administration.exception.ObjectNotFoundException;
import com.school.administration.mapper.StudentCourseRelMapper;
import com.school.administration.repository.StudentCourseRelRepository;
import com.school.administration.request.StudentCourseRelAddRequest;
import com.school.administration.request.StudentCourseRelUpdateRequest;
import com.school.administration.response.StudentCourseRelResponse;
import com.school.administration.service.StudenCourseRelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class StudentCourseRelImpl implements StudenCourseRelService{
    private final StudentCourseRelRepository studentCourseRelRepository;
    private final StudentCourseRelMapper studentCourseRelMapper;

    @Override
    public List<StudentCourseRelResponse> listAll() {
        List<StudentCourseRel> studentCourseRels = studentCourseRelRepository.findAll();
        List<StudentCourseRelResponse> studentCourseRelResponses = studentCourseRelMapper.toStudentCourseRelResponseList(studentCourseRels);
        return studentCourseRelResponses;
    }

    @Override
    public StudentCourseRelResponse save(StudentCourseRelAddRequest studentCourseRelAddRequest) {
        StudentCourseRel studentCourseRel = studentCourseRelMapper.toStudentCourseRel(studentCourseRelAddRequest);
        StudentCourseRel saved = studentCourseRelRepository.save(studentCourseRel);
        return studentCourseRelMapper.toStudentCourseRelResponse(saved);
    }

    @Override
    public StudentCourseRelResponse update(StudentCourseRelUpdateRequest studentCourseRelUpdateRequest) {
        Optional<StudentCourseRel> studentCourseRel = studentCourseRelRepository.findById(studentCourseRelUpdateRequest.getId());
        if(studentCourseRel.isPresent()){
            BeanUtils.copyProperties(studentCourseRelUpdateRequest, studentCourseRel.get());
            StudentCourseRel savedStudentCourseRel = studentCourseRelRepository.save(studentCourseRel.get());
            return studentCourseRelMapper.toStudentCourseRelResponse(savedStudentCourseRel);
        }
        else{
            throw new ObjectNotFoundException("Böyle Bir İlişki Bulunamadı!");
        }
    }

    @Override
    public void delete(Integer studentCourseRelId) {
        Optional<StudentCourseRel> studentCourseRel = studentCourseRelRepository.findById(studentCourseRelId);

        if (studentCourseRel.isPresent()){
            studentCourseRel.get().setEndDate(LocalDate.now());
            studentCourseRelRepository.save(studentCourseRel.get());
        }
    }
}
