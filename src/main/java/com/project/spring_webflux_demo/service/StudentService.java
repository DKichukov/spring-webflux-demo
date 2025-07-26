package com.project.spring_webflux_demo.service;

import com.project.spring_webflux_demo.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Flux<Student> getAllStudents();

    Mono<Student> getStudentById(Integer id);

}
