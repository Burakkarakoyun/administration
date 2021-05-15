package com.school.administration.controllers;

import com.school.administration.constants.Constants;
import com.school.administration.request.CourseAddRequest;
import com.school.administration.request.CourseUpdateRequest;
import com.school.administration.response.CourseResponse;
import com.school.administration.response.HttpResponseMessage;
import com.school.administration.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> getAll(){
        List<CourseResponse> courseResponses = courseService.listAll();

        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .items(courseResponses)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody CourseAddRequest courseAddRequest){
        CourseResponse courseResponse = courseService.save(courseAddRequest);

        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(courseResponse)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody CourseUpdateRequest courseUpdateRequest){
        CourseResponse courseResponse = courseService.update(courseUpdateRequest);

        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(courseResponse)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") int courseId){
        courseService.delete(courseId);
        HttpResponseMessage message = new HttpResponseMessage.HttpResponseMessageBuilder()
                .success(true)
                .item(Constants.DELETED_SUCCESS_STATUS)
                .build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}




