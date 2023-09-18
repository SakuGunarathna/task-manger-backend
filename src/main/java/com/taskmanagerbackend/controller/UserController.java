package com.taskmanagerbackend.controller;

import com.taskmanagerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/task-manager")
public class UserController {

    @Autowired
    UserService userService;

}