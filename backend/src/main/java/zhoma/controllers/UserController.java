package zhoma.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zhoma.model.User;
import zhoma.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping()
    List<User> getAllUser() {
        return service.getAll();
    }

    @PostMapping("/new")
    User savenewuser(@RequestBody User user) {
        return service.save_user(user);
    }

    @GetMapping("{id}")
    User getUserById(@PathVariable(name = "id") int id){
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable(name = "id")int id){
        return service.deleteUser(id);
    }
    @PutMapping("/edit/{id}")
    User edituser(@PathVariable(name = "id")int id,@RequestBody User user) {
        return service.editUser(id,user);
    }


}
