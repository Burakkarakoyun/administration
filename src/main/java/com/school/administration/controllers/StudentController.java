package com.school.administration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void init(){
        studentList.add(new Student(1,"Burak","Karakoyun"));
    }

    @PostMapping("/create")
    public ResponseEntity<Student> save(@RequestBody Student student){

        studentList.add(student);
        System.out.println("Öğrenci Başarıyla Eklendi");
        return ResponseEntity.ok(student);
    }
    @PostMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student){

        studentList.add(student);
        System.out.println("Öğrenci Başarıyla Güncellendi!");
        return ResponseEntity.ok(student);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> listAll(){
        return ResponseEntity.ok(studentList);
    }

    @DeleteMapping("/delete/{studentId}")
    public void delete(@PathVariable int studentId){
        studentList.remove(studentId);
    }
}
