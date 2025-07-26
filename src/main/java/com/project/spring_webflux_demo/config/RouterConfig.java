package com.project.spring_webflux_demo.config;

import com.project.spring_webflux_demo.controller.StudentController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    private final StudentController studentController;

    public RouterConfig(StudentController studentController) {
        this.studentController = studentController;
    }

    @Bean
    RouterFunction<ServerResponse> studentRouterConfig() {

        return RouterFunctions.route(
                        RequestPredicates.GET("/students"),
                        serverRequest -> studentController.getAllStudents())
                .andRoute(RequestPredicates.GET("/test"),
                        serverRequest -> studentController.getAllIntegers())
                .andRoute(RequestPredicates.GET("/students/{id}"),
                        serverRequest -> {
                            Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
                            return studentController.getStudentById(id);
                        });

    }

}
