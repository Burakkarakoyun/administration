package com.school.administration.controllers;
import com.school.administration.constants.Constants;
import com.school.administration.entities.Student;
import com.school.administration.request.StudentAddRequest;
import com.school.administration.request.StudentUpdateRequest;
import com.school.administration.response.HttpResponseMessage;
import com.school.administration.response.StudentResponse;
import com.school.administration.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = {"/list"})
    public ResponseEntity<?> getAll(){
        List<StudentResponse> studentResponses = studentService.listAll();

        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .items(studentResponses)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(value = {"/save"})
    public ResponseEntity<?> save(@RequestBody StudentAddRequest studentAddRequest){

        StudentResponse studentResponse = studentService.save(studentAddRequest);

        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(studentResponse)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping(value = {"/update"})
    public ResponseEntity<?> update( @RequestBody StudentUpdateRequest studentUpdateRequest){

        StudentResponse studentResponse = studentService.update(studentUpdateRequest);

        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(studentResponse)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping(value = {"/delete/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") int studentId) {
        studentService.delete(studentId);
        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(Constants.DELETED_SUCCESS_STATUS)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
