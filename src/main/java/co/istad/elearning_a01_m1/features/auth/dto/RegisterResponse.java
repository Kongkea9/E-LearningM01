package co.istad.elearning_a01_m1.features.auth.dto;


import lombok.Builder;

@Builder
public record RegisterResponse(
        String id,
        String username,
        String email,
        String firstName,
        String lastName,
        String genderOption,
        String biography
) {
}
