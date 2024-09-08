package com.kickstart.backend.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotNull
        @Email
        String email,
        @NotNull @NotEmpty
        String fullName,
        @NotNull @NotEmpty
        String bio,
        @NotNull @NotEmpty
        String profileUrl,
        @NotNull @NotEmpty
        String phone
) {


}
