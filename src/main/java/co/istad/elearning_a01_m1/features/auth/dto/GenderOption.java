package co.istad.elearning_a01_m1.features.auth.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum GenderOption {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");

    private final String gender;
    GenderOption(String gender) {
        this.gender = gender;
    }



}
