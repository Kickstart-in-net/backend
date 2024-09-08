package com.kickstart.backend.controllers;

import com.kickstart.backend.common.PageResponse;
import com.kickstart.backend.mappers.UserMapper;
import com.kickstart.backend.repository.UserRepository;
import com.kickstart.backend.requests.UserRequest;
import com.kickstart.backend.responses.UserResponse;
import com.kickstart.backend.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<PageResponse<UserResponse>> getAllUsers(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size
    ) {
        return ResponseEntity.ok (userService.getAllUsers(page, size));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<Long> updateUser(
            @PathVariable("userId") Long userId,
            @RequestBody UserRequest userReq
    ){
        return ResponseEntity.ok(userService.putUser(userId, userReq));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Long> deleteUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
