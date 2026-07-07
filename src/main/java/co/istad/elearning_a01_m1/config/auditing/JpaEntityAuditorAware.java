package co.istad.elearning_a01_m1.config.auditing;


import jakarta.annotation.Nullable;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaEntityAuditorAware implements AuditorAware<String> {


    @Nullable
    @Override
    public Optional<String> getCurrentAuditor() {

        //Get Authentication object

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        if(auth != null){
            Jwt jwt = (Jwt) auth.getPrincipal();

            if(jwt != null){
                return Optional.of(jwt.getSubject());
            }

        }

        return Optional.of("SYSTEM");
    }
}



