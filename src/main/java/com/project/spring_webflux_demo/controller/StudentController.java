package com.project.spring_webflux_demo.controller;

import com.project.spring_webflux_demo.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class StudentController {

    @GetMapping(value = "/test", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getAllIntegers() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping(value = "/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getAllStudents() {
        return Flux.just(new Student(1, "John", 20),
                        new Student(2, "Jane", 22),
                        new Student(3, "Jack", 21),
                        new Student(4, "Jill", 23),
                        new Student(5, "Joe", 24))
                .delayElements(Duration.ofSeconds(1))
                .log();
    }

}
