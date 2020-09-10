package com.codeclan.example.bookingSystem;

import com.codeclan.example.bookingSystem.models.Course;
import com.codeclan.example.bookingSystem.models.Customer;
import com.codeclan.example.bookingSystem.repositories.BookingRepository;
import com.codeclan.example.bookingSystem.repositories.CourseRepository;
import com.codeclan.example.bookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesByStarRating() {
		List<Course> foundCourses = courseRepository.findByStarRating(5);
		assertEquals("Intro Java", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomersByCourseName() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("Intro Java");
		assertEquals("Sandy", foundCustomers.get(0).getName());
	}

}
