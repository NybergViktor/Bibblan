package com.bibblan.bibblan.controllers;

import com.bibblan.bibblan.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
    @Autowired
    UsersService usersService;
}
