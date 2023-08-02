package ru.hogwarts.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.dto.in.StudentDtoIn;
import ru.hogwarts.dto.out.FacultyDtoOut;
import ru.hogwarts.dto.out.StudentDtoOut;
import ru.hogwarts.exceptions.AvatarProcessingException;
import ru.hogwarts.service.AvatarService;
import ru.hogwarts.service.StudentService;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("student")
public class StudentController {
    StudentService studentService;
    AvatarService avatarService;

    @PostMapping
    public StudentDtoOut createStudent(@RequestBody StudentDtoIn studentDtoIn) {
        return studentService.createStudent(studentDtoIn);
    }

    @GetMapping("{id}")
    public StudentDtoOut findStudent(@PathVariable Long id) {
        return studentService.findStudent(id);
    }

    @GetMapping
    public Collection<StudentDtoOut> findByAgeBetween(@RequestParam(required = false) Integer from,
                                                      @RequestParam(required = false) Integer to,
                                                      @RequestParam(required = false) Integer age) {
        if (from != null && to != null) {
            return studentService.findStudentsByAgeBetween(to, from);
        } else if (age != null) {
            return studentService.getStudentsByAge(age);
        }
        return studentService.getAllStudents();
    }

    @GetMapping("faculty/{id}")
    public FacultyDtoOut findFacultyOfStudent(@PathVariable Long id) {
        return studentService.findFacultyOfStudent(id);
    }

    @GetMapping("total")
    public Integer findTotalStudents() {
        return studentService.findTotalStudents();
    }

    @GetMapping("average-age")
    public Integer findAverageAgeOfStudents() {
        return studentService.findAverageAgeOfStudents();
    }

    @GetMapping("last-five")
    public Collection<StudentDtoOut> findLastFiveStudents() {
        return studentService.findLastFiveStudents();
    }

    @GetMapping("sorted_by_name")
    public Collection<String> getStudentsSortedByName(@RequestParam(value = "letter", defaultValue = "А") String letter) {
        return studentService.getStudentsSortedByName(letter);
    }

    @GetMapping("average_age")
    public Double getAverageAgeOfStudents() {
        return studentService.getAverageAgeOfStudents();
    }

    @GetMapping("students_by_threads")
    public String getStudentsByThreads() {
        studentService.getStudentsByThreads();
        return "Students are printed";
    }

    @GetMapping("students_by_threads_synchronized")
    public String getStudentsByThreadsSynchronized() {
        studentService.getStudentsByThreadsSynchronized();
        return "Students are printed synchronized";
    }

    @PutMapping
    public StudentDtoOut updateStudent(@RequestBody StudentDtoIn studentDtoIn) {
        return studentService.updateStudent(studentDtoIn);
    }

    @DeleteMapping("{id}")
    public StudentDtoOut deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @PatchMapping(value = "{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public StudentDtoOut uploadAvatar(@PathVariable Long id, @RequestPart MultipartFile avatar) throws IOException {
        if (avatar.getSize() > 1024 * 300) {
            throw new AvatarProcessingException();
        }
        return studentService.uploadAvatar(id, avatar);
    }
}
