package co.istad.elearning_a01_m1.features.student;


import co.istad.elearning_a01_m1.features.student.dto.StudentProfileResponse;
import co.istad.elearning_a01_m1.features.student.dto.UpdateStudentProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/me")
    public StudentProfileResponse me(){

        return studentService.me();

    }

    @PatchMapping
    public StudentProfileResponse updateProfile(@RequestBody UpdateStudentProfileRequest updateStudentProfileRequest){
           return studentService.updateProfile(updateStudentProfileRequest);
    }
}
