package ru.hogwarts.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.dto.out.FacultyDtoOut;
import ru.hogwarts.dto.in.StudentDtoIn;
import ru.hogwarts.dto.out.StudentDtoOut;
import ru.hogwarts.exceptions.StudentNotFoundException;
import ru.hogwarts.mapper.StudentMapper;
import ru.hogwarts.model.Avatar;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.FacultyRepository;
import ru.hogwarts.repository.StudentRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.hogwarts.utils.MethodLoading.getMethodName;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final FacultyRepository facultyRepository;
    private final AvatarService avatarService;
    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    public StudentDtoOut createStudent(StudentDtoIn studentDtoIn) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentDtoIn)));
    }

    public StudentDtoOut findStudent(long id) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return Optional.ofNullable(studentRepository.findById(id))
                .map(studentMapper::toDto)
                .orElseThrow(() -> {
                    log.error("Student with id = " + id + " wasn't found");
                    return new StudentNotFoundException(id);
                });
    }

    public Collection<StudentDtoOut> getAllStudents() {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public FacultyDtoOut findFacultyOfStudent(long studentId) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return Optional.ofNullable(studentRepository.findById(studentId))
                .map(studentMapper::toDto)
                .orElseThrow(() -> {
                    log.error("Student with id = " + studentId + " wasn't found");
                    return new StudentNotFoundException(studentId);
                })
                .getFaculty();
    }

    public StudentDtoOut updateStudent(StudentDtoIn student) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findById(student.getId())
                .map(old -> {
                    old.setName(student.getName());
                    old.setAge(student.getAge());
                    old.setFaculty(facultyRepository.findById(student.getFacultyId()));
                    return studentMapper.toDto(studentRepository.save(old));
                })
                .orElseThrow(() -> {
                    log.error("Student with id = " + student.getId() + " wasn't found");
                    return new StudentNotFoundException(student.getId());
                });
    }

    public StudentDtoOut deleteStudent(long id) {
        log.debug("Method '" + getMethodName() + "' is loading");
        Student student = Optional.ofNullable(studentRepository.findById(id))
                .orElseThrow(() -> {
                    log.error("Student with id = " + id + " wasn't found");
                    return new StudentNotFoundException(id);
                });
        studentRepository.delete(student);
        return studentMapper.toDto(student);
    }

    public Collection<StudentDtoOut> getStudentsByAge(int age) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findByAge(age).stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public Collection<StudentDtoOut> findStudentsByAgeBetween(int from, int to) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findByAgeBetween(from, to).stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public StudentDtoOut uploadAvatar(Long id, MultipartFile file) {
        log.debug("Method '" + getMethodName() + "' is loading");
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Student with id = " + id + " wasn't found");
                    return new StudentNotFoundException(id);
                });
        Avatar avatar = avatarService.uploadAvatar(id, file);
        StudentDtoOut studentDtoOut = studentMapper.toDto(student);
        studentDtoOut.setAvatarUri("http://localhost:8080/avatars/" + avatar.getId() + "/fs");
        return studentDtoOut;
    }

    public Integer findTotalStudents() {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findTotalStudents();
    }

    public Integer findAverageAgeOfStudents() {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findAverageAgeOfStudents();
    }

    public Collection<StudentDtoOut> findLastFiveStudents() {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findLastFiveStudents().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public Collection<String> getStudentsSortedByName(String letter) {
        return studentRepository.findAll().stream()
                .map(student -> student.getName().toUpperCase())
                .filter(student -> student.startsWith(letter))
                .sorted()
                .collect(Collectors.toList());
    }

    public Double getAverageAgeOfStudents() {
        return studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    public void getStudentsByThreads() {
        List<String> students = studentRepository.findAll().stream()
                .map(Student::getName)
                .toList();
        int size = students.size();

        if (size > 2) students.subList(0, 2).forEach(System.out::println);

        new Thread(() -> {
            if (size > 4) students.subList(2, 4).forEach(System.out::println);
        }).start();

        new Thread(() -> {
            if (size > 6) students.subList(4, 6).forEach(System.out::println);
        }).start();
    }

    public synchronized void getStudentsByThreadsSynchronized() {
        getStudentsByThreads();
    }
}