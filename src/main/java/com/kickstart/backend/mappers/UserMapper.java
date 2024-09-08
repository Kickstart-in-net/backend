package com.kickstart.backend.mappers;

import com.kickstart.backend.entities.User;
import com.kickstart.backend.responses.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .bio(user.getBio())
                .profileUrl(user.getProfileUrl())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phone(user.getPhoneNumber())
                .build();
    }
}
