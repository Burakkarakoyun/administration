package com.school.administration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void init(){
        studentList.add(new Student(1,"Burak","Karakoyun"));
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        studentList.add(student);
        System.out.println("Öğrenci Başarıyla Eklendi");
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> listAll(){
        return ResponseEntity.ok(studentList);
    }

    @DeleteMapping
    public ResponseEntity<Student> delete(@RequestBody Student student){
        studentList.remove(student);
        return ResponseEntity.ok(student);

        //studentList.stream().filter(s-> s.getId()==studentId)
    }
}
