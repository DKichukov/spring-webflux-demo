package com.project.spring_webflux_demo.repository;

import com.project.spring_webflux_demo.entity.Student;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
    @Query("select sleep(1), s.id, s.name, s.age FROM mydb.students s")
    Flux<Student> findAllStudents();
}
