package com.bibblan.bibblan.services;

import com.bibblan.bibblan.models.Users;
import com.bibblan.bibblan.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    // add a new user
    public Users createUsers(Users users) {
        return usersRepository.save(users);
    }

    // get a list with all users
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    // update a users information
    public Users updateUsers(Users users) {
        return usersRepository.save(users);
    }

    // get a specifik user using id
    public Users usersById(String id) {
        return usersRepository.findById(id).get();
    }

    // delete user
    public String deleteUsers(String id) {
        usersRepository.deleteById(id);
        return "User with id: " + id + " has been deleted";
    }

}
