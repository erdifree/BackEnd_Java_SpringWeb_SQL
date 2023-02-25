package work.group.Call.center.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.Login;
import work.group.Call.center.repository.LoginRepository;


import java.util.Optional;

@RestController
@RequestMapping ("/userlogin")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/{id}")
    private Login getByID(@PathVariable Integer id) {
        Optional<Login> result = loginRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping()
    public Login searchUser(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password) {
   Optional<Login>result= Optional.ofNullable(loginRepository.findByUsernameAndPassword(username, password));
    if (!result.isEmpty()){
        return result.get();
    }else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND );
    }
    }
}