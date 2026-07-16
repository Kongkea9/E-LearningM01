package co.istad.elearning_a01_m1.features.student.dto;

import co.istad.elearning_a01_m1.features.auth.dto.GenderOption;
import lombok.Builder;

@Builder
public record StudentProfileResponse(
        String userId,
        String email,
        String firstName,
        String lastName,
        String gender,
        String biography,
        String profilePicture,
        String university,
        String major,
        String phoneNumber,
        String githubLink,
        String facebookLink
) {
}
