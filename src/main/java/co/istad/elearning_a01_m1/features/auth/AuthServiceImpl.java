package co.istad.elearning_a01_m1.features.auth;


import co.istad.elearning_a01_m1.config.props.KeycloakAdminClientProps;
import co.istad.elearning_a01_m1.features.auth.dto.RegisterRequest;
import co.istad.elearning_a01_m1.features.auth.dto.RegisterResponse;
import co.istad.elearning_a01_m1.features.student.StudentProfile;
import co.istad.elearning_a01_m1.features.student.StudentProfileRepository;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final Keycloak keycloak;
    private final KeycloakAdminClientProps props;
    private final StudentProfileRepository studentProfileRepository;

    @Override
    public RegisterResponse Register(RegisterRequest registerRequest) {


        //validate password

        if(!registerRequest.password().equals(registerRequest.confirmPassword())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Password is not match"
            );
        }


        //Register user to keycloak
        UserRepresentation user = new UserRepresentation();
        user.setUsername(registerRequest.username());
        user.setEmail(registerRequest.email());
        user.setFirstName(registerRequest.firstName());
        user.setLastName(registerRequest.lastName());


        // set custom attribute
        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("gender",List.of(registerRequest.gender().getGender()));
        attributes.put("biography", List.of(registerRequest.biography()));
        user.setAttributes(attributes);

        // set credential
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(registerRequest.password());
        user.setCredentials(List.of(credential));


        user.setEnabled(true);
        user.setEmailVerified(false);


        // call keycloak api

        UsersResource usersResource = keycloak.realm(props.getTargetRealm()).users();


        try(Response response = usersResource.create(user)){
            if(response.getStatus() == HttpStatus.CREATED.value()){
                UserRepresentation createdUser = usersResource
                        .search(user.getUsername())
                        .getFirst();

                log.info("Created User {}", createdUser.getId());

//
                StudentProfile studentProfile = new StudentProfile();
                studentProfile.setUserId(createdUser.getId());

                try {
                    log.info("userfacebook {}",studentProfile.getFacebookLink());
                    studentProfileRepository.save(studentProfile);
                    log.info("Saved student profile");
                } catch (Exception e) {
                    log.error("Database save failed", e);
                    throw e;
                }



//                studentProfileRepository.save(studentProfile);

                // save user to database


                UserResource userResource = keycloak.realm(props.getTargetRealm()).users().get(createdUser.getId());
                userResource.sendVerifyEmail();

                // start assign role

                RolesResource rolesResource = keycloak.realm(props.getTargetRealm())
                        .roles();

                RoleRepresentation roleUser = rolesResource.get(RoleEnum.USER.name()).toRepresentation();

                RoleRepresentation roleAdmin = rolesResource.get(RoleEnum.ADMIN.name()).toRepresentation();

                log.info("Check role user from keycloak: {}",roleUser);
                log.info("Check role admin from keycloak: {}",roleAdmin);


                userResource.roles().realmLevel().add(List.of(roleUser, roleAdmin));

                return RegisterResponse.builder()
                        .id(createdUser.getId())
                        .username(createdUser.getUsername())
                        .email(createdUser.getEmail())
                        .firstName(createdUser.getFirstName())
                        .lastName(createdUser.getLastName())
                        .genderOption(createdUser.getAttributes().get("gender").getFirst())
                        .biography(createdUser.getAttributes().get("biography").getFirst())
                        .build();
            }


        }


        return null;
    }
}
