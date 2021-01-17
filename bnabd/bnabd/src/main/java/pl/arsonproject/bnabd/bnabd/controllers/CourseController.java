package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.arsonproject.bnabd.bnabd.model.Course;
import pl.arsonproject.bnabd.bnabd.model.User;
import pl.arsonproject.bnabd.bnabd.repository.UserRepository;
import pl.arsonproject.bnabd.bnabd.service.dto.UserDto;

import java.net.URI;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("api/v1")
public class CourseController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/instructors/{username}/courses")
//    public List<Course> getAllCourses(@PathVariable String username) {
//        return courseManagementService.findAll();
//    }
//
//    @GetMapping("/instructors/{username}/courses/{id}")
//    public Course getCourse(@PathVariable String username, @PathVariable long id) {
//        return courseManagementService.findById(id);
//    }
//
//    @DeleteMapping("/instructors/{username}/courses/{id}")
//    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id) {
//
//        Course course = courseManagementService.deleteById(id);
//
//        if (course != null) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/instructors/{username}/courses/{id}")
//    public ResponseEntity<Course> updateCourse(@PathVariable String username, @PathVariable long id,
//                                               @RequestBody Course course) {
//
//        Course courseUpdated = courseManagementService.save(course);
//
//        return new ResponseEntity<Course>(course, HttpStatus.OK);
//    }
//
    @PostMapping("/users/signin")
    public ResponseEntity.BodyBuilder createUser(@RequestBody UserDto user) {
        userRepository.save(new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),user.getRole()));
        return ResponseEntity.accepted();
    }

}