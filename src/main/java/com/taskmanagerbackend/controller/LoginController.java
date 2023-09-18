package com.taskmanagerbackend.controller;

import com.google.common.net.HttpHeaders;
import com.taskmanagerbackend.dto.Token;
import com.taskmanagerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity LoginWithGoogleOauth2(@RequestBody Token token, HttpServletResponse response) {

        String authToken = userService.loginOAuthGoogle(token);

        response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + authToken);
        return ResponseEntity.ok().build();
    }
}
