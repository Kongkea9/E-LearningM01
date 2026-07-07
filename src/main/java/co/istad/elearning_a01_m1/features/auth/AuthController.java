package co.istad.elearning_a01_m1.features.auth;


import co.istad.elearning_a01_m1.features.auth.dto.RegisterRequest;
import co.istad.elearning_a01_m1.features.auth.dto.RegisterResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){

         return authService.Register(request);
    }


}
