package com.project.spring_webflux_demo.controller;

import com.project.spring_webflux_demo.entity.Student;
import com.project.spring_webflux_demo.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    public Mono<ServerResponse> getAllIntegers() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofSeconds(1));

        return ServerResponse.
                ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(integerFlux, Integer.class);
    }

    public Mono<ServerResponse> getAllStudents() {

        Flux<Student> allStudents = studentService.getAllStudents()
                .delayElements(Duration.ofSeconds(1));

        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(allStudents, Student.class);

    }

    public Mono<ServerResponse> getStudentById(Integer id) {
        return studentService.getStudentById(id)
                .flatMap(student -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(student))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
