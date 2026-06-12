package com.sp.authservice.infrastructure.input.controller;

import com.sp.authservice.application.dto.UserDTO;
import com.sp.authservice.application.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final IUserHandler userHandler;

    @PostMapping("/admin")
    public ResponseEntity<Void> createAdmin(@Valid @RequestBody UserDTO userDTO) {
        userHandler.createAdmin(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/client")
    public ResponseEntity<Void> createClient(@Valid @RequestBody UserDTO userDTO) {
        userHandler.createClient(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
