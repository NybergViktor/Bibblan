package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.models.Users;
import com.bibblan.bibblan.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
    @Autowired
    UsersService usersService;


    // POST
    // add a new user
    @PostMapping()
    public Users createUsers(@RequestBody Users users) {
        return usersService.createUsers(users);
    }

    // GET
    // GET all users
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }



    // PUT
    // UPDATE user
    @PutMapping("/update/{id}")
    public Users updateUsers(@PathVariable String id, @RequestBody Users usersDetails) {
        return usersService.updateUsers(usersDetails);
    }

    // GET by id
    // GET a user using id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUsersById(@PathVariable String id) {
        return usersService.usersById(id);
    }

    // DELETE
    // Delete user
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUsers(@PathVariable String id) {
        return usersService.deleteUsers(id);
    }
}
