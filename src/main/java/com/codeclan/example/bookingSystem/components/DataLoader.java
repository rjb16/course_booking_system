package com.codeclan.example.bookingSystem.components;

import com.codeclan.example.bookingSystem.models.Booking;
import com.codeclan.example.bookingSystem.models.Course;
import com.codeclan.example.bookingSystem.models.Customer;
import com.codeclan.example.bookingSystem.repositories.BookingRepository;
import com.codeclan.example.bookingSystem.repositories.CourseRepository;
import com.codeclan.example.bookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Course java = new Course("Intro Java", "Edinburgh", 5);
        courseRepository.save(java);

        Course javaScript = new Course("Advanced JavaScript", "Glasgow", 3);
        courseRepository.save(javaScript);

        Customer sandy = new Customer("Sandy", "Edinburgh", 40);
        customerRepository.save(sandy);

        Customer juan = new Customer("Juan", "Glasgow", 35);
        customerRepository.save(juan);

        Booking booking1 = new Booking("11-09-2020", java, sandy);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("20-11-2020", javaScript, juan);
        bookingRepository.save(booking2);
    }
}
