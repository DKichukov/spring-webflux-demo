package com.project.spring_webflux_demo.service;

import com.project.spring_webflux_demo.entity.Student;
import com.project.spring_webflux_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Flux<Student> getAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public Mono<Student> getStudentById(Integer id) {

        return studentRepository.findById(id);
    }

}
