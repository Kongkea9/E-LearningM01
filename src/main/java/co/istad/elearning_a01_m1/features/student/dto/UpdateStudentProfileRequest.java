package co.istad.elearning_a01_m1.features.student.dto;

import co.istad.elearning_a01_m1.features.auth.dto.GenderOption;

public record UpdateStudentProfileRequest(

        String firstName,
        String lastName,
        GenderOption gender,
        String biography,
        String profilePicture,
        String university,
        String major,
        String phoneNumber,
        String githubLink,
        String facebookLink
) {
}
