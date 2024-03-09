package com.bibblan.bibblan.services;

import com.bibblan.bibblan.dto.user.FindUserDTO;
import com.bibblan.bibblan.dto.user.PostUserDTO;
import com.bibblan.bibblan.dto.user.PutUserDTO;
import com.bibblan.bibblan.models.Users;
import com.bibblan.bibblan.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    // add a new user
    public ResponseEntity<?> createUsers(PostUserDTO postUserDTO) {
        Users newUser = new Users();
        newUser.setName(postUserDTO.getName());
        newUser.setEmail(postUserDTO.getEmail());
        newUser.setAge(postUserDTO.getAge());
        newUser.setPassword(postUserDTO.getPassword());
        usersRepository.save(newUser);
        return ResponseEntity.ok("User created");
    }

    // get a list with all users
    public List<Users> getAllUsers() {
        try {
            return usersRepository.findAll();
        } catch (NullPointerException p){
            throw new NullPointerException("Could not find any users");
        }
    }

    // update a users information
    public ResponseEntity<?> updateUsers(PutUserDTO putUserDTO) {
        Users foundUser = usersRepository.findById(putUserDTO.getId())
                .orElseThrow(() -> new RuntimeException("User does not exist"));
        if (putUserDTO.getName() != null) {
            foundUser.setName(putUserDTO.getName());
        }
        if (putUserDTO.getEmail() != null) {
            foundUser.setEmail(putUserDTO.getEmail());
        }
        if (putUserDTO.getAge() != 0) {
            foundUser.setAge(putUserDTO.getAge());
        }
        if (putUserDTO.getPassword() != null) {
            foundUser.setPassword(putUserDTO.getPassword());
        }
        usersRepository.save(foundUser);
        return ResponseEntity.ok("User updated");
    }

    // get a specifik user using id
    public ResponseEntity<?> usersById(FindUserDTO findUserDTO) {
        Users foundUser = usersRepository.findById(findUserDTO.getId())
                .orElseThrow(() -> new RuntimeException("User does not exist"));
        return ResponseEntity.ok(usersRepository.findById(findUserDTO.getId()));
    }

    // delete user
    public ResponseEntity<?> deleteUsers(FindUserDTO findUserDTO) {
        Users deleteUser = usersRepository.findById(findUserDTO.getId())
                .orElseThrow(() -> new RuntimeException("User does not exist"));
        usersRepository.delete(deleteUser);
        return ResponseEntity.ok("User was deleted.");

    }

}
