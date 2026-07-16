package co.istad.elearning_a01_m1.features.student;


import co.istad.elearning_a01_m1.features.auth.dto.GenderOption;
import co.istad.elearning_a01_m1.features.student.dto.StudentProfileResponse;
import co.istad.elearning_a01_m1.features.student.dto.UpdateStudentProfileRequest;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.*;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public abstract class StudentProfileMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
   abstract void mapUpdateStudentProfileRequestToStudentProfile(
           UpdateStudentProfileRequest updateStudentProfileRequest,
           @MappingTarget StudentProfile studentProfile
   );


    public StudentProfileResponse map(
            UserRepresentation user,
            StudentProfile profile
    ) {
        return StudentProfileResponse.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getAttributes().get("gender").getFirst())
                .biography(user.getAttributes().get("biography").getFirst())

                .profilePicture(profile.getProfilePicture())
                .university(profile.getUniversity())
                .major(profile.getMajor())
                .phoneNumber(profile.getPhoneNumber())
                .githubLink(profile.getGithubLink())
                .facebookLink(profile.getFacebookLink())

                .build();
    }

}
