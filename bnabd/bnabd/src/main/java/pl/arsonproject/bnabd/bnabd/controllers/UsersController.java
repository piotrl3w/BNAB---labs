package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arsonproject.bnabd.bnabd.model.Users;
import pl.arsonproject.bnabd.bnabd.repository.UsersRepository;

@RestController
@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@RequestMapping("api/v1/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/login")
    public Boolean Login(@RequestBody UserRequest user){
        try {
            Users dbUser = usersRepository.findAll().stream().filter(x -> x.getName().equals(user.getName())).findFirst().get();
            return dbUser != null && dbUser.getPassword().equals(user.getPassword());
        }catch (Exception e){
            return false;
        }
    }

    static class UserRequest{
        private String Name;
        private String Password;

        public UserRequest(String name, String password) {
            Name = name;
            Password = password;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }
    }
}
