package pl.arsonproject.bnabd.bnabd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pl.arsonproject.bnabd.bnabd.model.User;
import pl.arsonproject.bnabd.bnabd.model.UserRole;
import pl.arsonproject.bnabd.bnabd.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
public class DataLoader {

        @Autowired
        private UserRepository userRepository;

        @PostConstruct
        public void initialize() {
            User user = new User("admin", "admin", "test@test.pl", DigestUtils.md5DigestAsHex("test".getBytes()), UserRole.ADMIN);
            userRepository.save(user);
        }
}
