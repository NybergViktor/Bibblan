package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.dto.user.FindUserDTO;
import com.bibblan.bibblan.dto.user.PostUserDTO;
import com.bibblan.bibblan.dto.user.PutUserDTO;
import com.bibblan.bibblan.exception.EntityNotFoundException;
import com.bibblan.bibblan.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
    @Autowired
    UsersService usersService;


    // POST
    // add a new user
    @PostMapping()
    public ResponseEntity<?> createUsers(@RequestBody PostUserDTO postUserDTO) {
        return usersService.createUsers(postUserDTO);
    }

    // GET
    // GET all users
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(usersService.getAllUsers());
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    // PUT
    // UPDATE user
    @PutMapping()
    public ResponseEntity<?> updateUsers(@RequestBody PutUserDTO putUserDTO) {
        try {
            return usersService.updateUsers(putUserDTO);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // GET by id
    // GET a user using id
    @GetMapping("/find")
    public ResponseEntity<?> getUsersById(@RequestBody FindUserDTO findUserDTO) {
        try {
            return usersService.usersById(findUserDTO);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // DELETE
    // Delete user
    @DeleteMapping()
    public ResponseEntity<?> deleteUsers(@RequestBody FindUserDTO findUserDTO) {
        try {
            return usersService.deleteUsers(findUserDTO);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
