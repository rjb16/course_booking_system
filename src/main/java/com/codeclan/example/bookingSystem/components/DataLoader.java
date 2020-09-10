package com.codeclan.example.bookingSystem.components;

import com.codeclan.example.bookingSystem.models.Course;
import com.codeclan.example.bookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Course java = new Course("Intro Java", "Edinburgh", 5);
        courseRepository.save(java);

        Course javaScript = new Course("Advanced JavaScript", "Glasgow", 3);
        courseRepository.save(javaScript);
    }
}
