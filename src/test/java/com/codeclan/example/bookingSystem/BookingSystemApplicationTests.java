package com.codeclan.example.bookingSystem;

import com.codeclan.example.bookingSystem.models.Booking;
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
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameIgnoreCase("Intro Java");
		assertEquals("Sandy", foundCustomers.get(0).getName());
	}

	@Test
	public void canFindCoursesByCustomerName() {
		List<Course> foundCourses = courseRepository.findByBookingsCustomerNameIgnoreCase("Juan");
		assertEquals("Advanced JavaScript", foundCourses.get(0).getName());
	}

	@Test
	public void canFindBookingsByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("11-09-2020");
		assertEquals(1L, foundBookings.get(0).getId().longValue());
	}

	@Test
	public void canFindCustomersByTownAndCourseName() {
		List<Customer> foundCustomers = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Edinburgh", "Intro Java");
		assertEquals("Sandy", foundCustomers.get(0).getName());
	}

	@Test
	public void canFindCustomersByMinAgeAndTownAndCourseName() {
		List<Customer> foundCustomers = customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(30, "Glasgow", "Advanced JavaScript");
		assertEquals("Juan", foundCustomers.get(0).getName());
	}

}
