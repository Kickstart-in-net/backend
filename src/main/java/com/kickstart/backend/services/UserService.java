package com.kickstart.backend.services;

import com.kickstart.backend.common.PageResponse;
import com.kickstart.backend.entities.User;
import com.kickstart.backend.mappers.UserMapper;
import com.kickstart.backend.repository.UserRepository;
import com.kickstart.backend.requests.UserRequest;
import com.kickstart.backend.responses.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public PageResponse<UserResponse> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(pageable);

        List<UserResponse> userResponses = users.stream()
                .map(userMapper::toUserResponse).toList();

        return new PageResponse<>(
                userResponses,
                users.getNumber(),
                users.getSize(),
                users.getTotalElements (),
                users.getTotalPages (),
                users.isFirst (),
                users.isLast ()
        );
    }

    public UserResponse getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserResponse)
                .orElse(null);
    }

    public Long putUser(Long id, UserRequest newUser) {
        User user = userRepository.findById(id)
                        .orElseThrow(()-> new EntityNotFoundException("No user found with id "+ id));
        user.setFullName(newUser.fullName());
        user.setEmail(newUser.email());
        user.setBio(newUser.bio());
        user.setProfileUrl(newUser.profileUrl());
        user.setPhoneNumber(newUser.phone());

        userRepository.save(user);
        return user.getId();
    }

    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
