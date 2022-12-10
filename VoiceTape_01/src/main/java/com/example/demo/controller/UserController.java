package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .nickname(request.getNickname())
                .role(request.getRole())
                .build();

        userService.createUser(user);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{username}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);

        GetUserResponse response = GetUserResponse.builder()
                .username(user.getUsername())
                .nickname(user.getNickname())
                .role(user.getRole())
                .build();

        return ResponseEntity.ok(response);
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserRequest request) {
        userService.updateUserByUsername(request.getUsername());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.ok().build();
    }


    @Data
    static class CreateUserRequest {

        @NotNull
        @Size(min = 1, max = 20)
        private String username;

        @NotNull
        @Size(min = 1, max = 20)
        private String nickname;

        private Role role;

    }


    @Builder
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class GetUserResponse {
        private String username;
        private String nickname;
        private Role role;
    }


    @Data
    static class UpdateUserRequest {
        @NotNull
        @Size(min = 1, max = 20)
        private String username;

        @NotNull
        @Size(min = 1, max = 20)
        private String nickname;

        private Role role;
    }
}
