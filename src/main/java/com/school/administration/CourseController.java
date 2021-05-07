package com.school.administration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private List<Course> courseList = new ArrayList<>();

    @PostConstruct
    public void init(){
        courseList.add(new Course(1,5,"Math"));
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course){
        courseList.add(course);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> listAll(){
        return ResponseEntity.ok(courseList);
    }
    @DeleteMapping
    public ResponseEntity<Course> delete(@RequestBody Course course){
        courseList.remove(course);
        return ResponseEntity.ok(course);
    }
}
