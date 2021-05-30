package com.school.administration.service.impl;

import com.school.administration.entities.Course;
import com.school.administration.exception.ObjectNotFoundException;
import com.school.administration.mapper.CourseMapper;
import com.school.administration.repository.CourseRepository;
import com.school.administration.request.CourseAddRequest;
import com.school.administration.request.CourseUpdateRequest;
import com.school.administration.response.CourseResponse;
import com.school.administration.service.CourseService;
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
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponse> listAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = courseMapper.toCourseResponseList(courses);
        return courseResponses;
    }

    @Override
    public CourseResponse save(CourseAddRequest courseAddRequest) {
        Course course = courseMapper.toCourse(courseAddRequest);
        Course saved = courseRepository.save(course);
        return courseMapper.toCourseResponse(saved);
    }
    @Override
    public CourseResponse update (CourseUpdateRequest courseUpdateRequest){
        Optional<Course> course = courseRepository.findById(courseUpdateRequest.getCourseId());
        if(course.isPresent()){
            BeanUtils.copyProperties(courseUpdateRequest, course.get());
            Course savedCourse = courseRepository.save(course.get());
            return courseMapper.toCourseResponse(savedCourse);
        }
        else{
            throw new ObjectNotFoundException("Kurs Bulunamadı!");
        }
    }

    @Override
    public void delete(Integer courseId){
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            course.get().setEndDate(LocalDate.now());
            courseRepository.save(course.get());
        }
    }

}
