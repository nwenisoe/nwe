package com.example.samplerestapi;

import com.example.samplerestapi.dao.EmployeeDao;
import com.example.samplerestapi.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class SampleRestApiApplication {

    private final EmployeeDao employeeDao;
    @Bean
    public ApplicationRunner runner(){
        return r -> {
            Employee e1 = new Employee("John", "Doe", "john@jmail.com");
            Employee e2 = new Employee("John", "William", "william@jmail.com");
            Employee e3 = new Employee("Thomas", "Hardy", "thomas@jmail.com");
            Employee e4 = new Employee("Charles", "Dickens", "charles@jmail.com");
            Employee e5 = new Employee("Henery", "Dickens", "henery@jmail.com");

            Stream.of(e1, e2, e3, e4, e5)
                    .forEach(employeeDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleRestApiApplication.class, args);
    }

}
