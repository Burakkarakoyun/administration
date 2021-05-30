package com.school.administration.controllers;
import com.school.administration.constants.Constants;
import com.school.administration.request.StudentCourseRelAddRequest;
import com.school.administration.request.StudentCourseRelUpdateRequest;
import com.school.administration.response.HttpResponseMessage;
import com.school.administration.response.StudentCourseRelResponse;
import com.school.administration.service.StudenCourseRelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rel")
public class StudentCourseRelController {
    private final StudenCourseRelService studentCourseRelService;

    @GetMapping(value = {"/list"})
    public ResponseEntity<?> getAll(){
        List<StudentCourseRelResponse> studentCourseRelResponses = studentCourseRelService.listAll();
        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .items(studentCourseRelResponses)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @PostMapping(value = {"/save"})
    public ResponseEntity<?> save(@RequestBody StudentCourseRelAddRequest studentCourseRelAddRequest){
        StudentCourseRelResponse studentCourseRelResponse = studentCourseRelService.save(studentCourseRelAddRequest);
        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(studentCourseRelResponse)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = {"/update"})
    public ResponseEntity<?> update(@RequestBody StudentCourseRelUpdateRequest studentCourseRelUpdateRequest){
        StudentCourseRelResponse studentCourseRelResponse = studentCourseRelService.update(studentCourseRelUpdateRequest);
        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(studentCourseRelResponse)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @DeleteMapping(value = {"/delete/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") int studentCourseRelId){
        studentCourseRelService.delete(studentCourseRelId);
        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(Constants.DELETED_SUCCESS_STATUS)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
