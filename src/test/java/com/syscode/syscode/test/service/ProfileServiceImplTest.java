package com.syscode.syscode.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.syscode.syscode.test.common.dto.ResponseIdDto;
import com.syscode.syscode.test.common.dto.StudentDto;
import com.syscode.syscode.test.common.dto.StudentPostDto;
import com.syscode.syscode.test.domain.StudentEntity;
import com.syscode.syscode.test.repository.ProfileRepository;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

class ProfileServiceImplTest {

  @InjectMocks
  ProfileServiceImpl studentService;

  @Mock
  ProfileRepository studentRepository;

  StudentEntity student;
  StudentPostDto studentDto;
  UUID randomUUID;
  Pageable pageable = PageRequest.of(1 - 1, 10);
  Page<StudentEntity> pages;
  List<StudentEntity> students = new ArrayList<>();

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    student = new StudentEntity();
    student.setId(UUID.randomUUID());
    student.setName("admin");
    student.setEmail("admin@test.com");
    students.add(student);
    pages = new PageImpl<>(students, pageable, students.size());
    randomUUID = UUID.randomUUID();
    studentDto = new StudentPostDto("test", "test@test.com");
  }

  @Test
  void testListStudent() {
    when(studentRepository.findAll(pageable)).thenReturn(pages);
    StudentDto dto = studentService.getStudentListByFilter(pageable).getResults().get(0);
    assertNotNull(dto);
    assertEquals("admin", dto.getName());
  }

  @Test
  void deleteStudent() {
    doNothing().when(studentRepository).deleteById(randomUUID);
    studentService.deleteStudentById(randomUUID);
    verify(studentRepository).deleteById(randomUUID);
  }

  @Test
  void testUpdateStudentById() {
    StudentEntity existingStudent =
        new StudentEntity(randomUUID, "Old Name", "old.email@example.com");
    Optional<StudentEntity> optionalStudent = Optional.of(existingStudent);

    when(studentRepository.findById(randomUUID)).thenReturn(optionalStudent);
    when(studentRepository.saveAndFlush(existingStudent)).thenReturn(existingStudent);
    ResponseIdDto response = studentService.updateStudentById(randomUUID, studentDto);

    verify(studentRepository).findById(randomUUID);

    verify(studentRepository).saveAndFlush(existingStudent);

    assertEquals(randomUUID, response.getId());

    assertEquals(studentDto.getName(), existingStudent.getName());
    assertEquals(studentDto.getEmail(), existingStudent.getEmail());
  }

  @Test
  void testSaveStudent() {
    when(studentRepository.save(any(StudentEntity.class))).thenReturn(student);
    ResponseIdDto response = studentService.saveStudent(studentDto);
    verify(studentRepository).save(any(StudentEntity.class));
    assertEquals(student.getId(), response.getId());
  }
}
