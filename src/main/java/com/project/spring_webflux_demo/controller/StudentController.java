package com.project.spring_webflux_demo.controller;

import com.project.spring_webflux_demo.entity.Student;
import com.project.spring_webflux_demo.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getAllIntegers() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping(value = "/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAllStudents() {
        Flux<Student> allStudents = studentService.getAllStudents();

        return allStudents.delayElements(Duration.ofSeconds(1)).log();

    }

}
