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

    @PostMapping("/users/signin")
    public ResponseEntity.BodyBuilder createUser(@RequestBody UserDto user) {
        userRepository.save(new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),user.getRole()));
        return ResponseEntity.accepted();
    }

}