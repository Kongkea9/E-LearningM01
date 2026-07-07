package co.istad.elearning_a01_m1.features.auth;

import co.istad.elearning_a01_m1.features.auth.dto.RegisterRequest;
import co.istad.elearning_a01_m1.features.auth.dto.RegisterResponse;

public interface AuthService {

    RegisterResponse Register(RegisterRequest request);
}
