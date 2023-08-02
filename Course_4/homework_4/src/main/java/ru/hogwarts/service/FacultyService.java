package ru.hogwarts.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.dto.in.FacultyDtoIn;
import ru.hogwarts.dto.out.FacultyDtoOut;
import ru.hogwarts.dto.out.StudentDtoOut;
import ru.hogwarts.exceptions.FacultyNotFoundException;
import ru.hogwarts.mapper.FacultyMapper;
import ru.hogwarts.mapper.StudentMapper;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.repository.FacultyRepository;
import ru.hogwarts.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.hogwarts.utils.MethodLoading.getMethodName;

@Service
@AllArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final Logger log = LoggerFactory.getLogger(FacultyService.class);

    public FacultyDtoOut createFaculty(FacultyDtoIn facultyDtoIn) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return facultyMapper.toDto(facultyRepository.save(facultyMapper.toEntity(facultyDtoIn)));
    }

    public FacultyDtoOut findFaculty(long id) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return Optional.ofNullable(facultyRepository.findById(id))
                .map(facultyMapper::toDto)
                .orElseThrow(() -> {
                    log.error("Faculty with id = " + id + " wasn't found");
                    return new FacultyNotFoundException(id);
                });
    }

    public Collection<FacultyDtoOut> getAllFaculties() {
        log.debug("Method '" + getMethodName() + "' is loading");
        return facultyRepository.findAll().stream()
                .map(facultyMapper::toDto)
                .collect(Collectors.toList());
    }

    public Collection<FacultyDtoOut> findFacultiesByColourOrName(String colourOrName) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return facultyRepository
                .findByColourContainingIgnoreCaseOrNameContainingIgnoreCase(colourOrName, colourOrName)
                .stream()
                .map(facultyMapper::toDto)
                .collect(Collectors.toList());
    }

    public Collection<StudentDtoOut> findStudentsOfFaculty(Long facultyId) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return studentRepository.findByFaculty_Id(facultyId).stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    public FacultyDtoOut updateFaculty(FacultyDtoIn faculty) {
        log.debug("Method '" + getMethodName() + "' is loading");
        return facultyRepository.findById(faculty.getId())
                .map(old -> {
                    old.setName(faculty.getName());
                    old.setColour(faculty.getColour());
                    return facultyMapper.toDto(facultyRepository.save(old));
                })
                .orElseThrow(() -> {
                    log.error("Faculty with id = " + faculty.getId() + " wasn't found");
                    return new FacultyNotFoundException(faculty.getId());
                });
    }

    public FacultyDtoOut deleteFaculty(long id) {
        log.debug("Method '" + getMethodName() + "' is loading");
        Faculty faculty = Optional.ofNullable(facultyRepository.findById(id))
                .orElseThrow(() -> {
                    log.error("Faculty with id = " + id + " wasn't found");
                    return new FacultyNotFoundException(id);
                });
        facultyRepository.delete(faculty);
        return facultyMapper.toDto(faculty);
    }
}