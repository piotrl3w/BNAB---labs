package pl.arsonproject.bnabd.bnabd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arsonproject.bnabd.bnabd.model.User;
import pl.arsonproject.bnabd.bnabd.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long userId){
        return userRepository.findById(userId).isPresent() ? userRepository.findById(userId).get() : null;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).isPresent() ? userRepository.findByEmail(email).get() : null;
    }

    public void save(User user){
        userRepository.save(user);
    }
}