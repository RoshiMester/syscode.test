package com.syscode.syscode.test.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.syscode.syscode.test.common.dto.ResponseIdDto;
import com.syscode.syscode.test.common.dto.StudentDto;
import com.syscode.syscode.test.common.dto.StudentListDto;
import com.syscode.syscode.test.common.dto.StudentPostDto;
import com.syscode.syscode.test.common.exception.util.SyscodeExceptionUtils;
import com.syscode.syscode.test.common.util.JsonMapper;
import com.syscode.syscode.test.domain.StudentEntity;
import com.syscode.syscode.test.repository.ProfileRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.syscode.syscode.test.common.constant.Constant.STUDENT_NOT_FOUND;

@Service
public class ProfileServiceImpl implements ProfileService {
  private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

  private final ProfileRepository profileRepository;

  @Autowired
  public ProfileServiceImpl(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @Override
  public StudentListDto getStudentListByFilter(Pageable pageable) {
    List<StudentDto> dtoList = new ArrayList<>();
    Page<StudentEntity> studentList = profileRepository.findAll(pageable);
    studentList.forEach(
        item ->
            dtoList.add(
                (StudentDto) JsonMapper.convertObjToDto(item, new TypeReference<StudentDto>() {})));

    logger.debug("Student listed with count: {}", studentList.getTotalElements());
    return new StudentListDto(dtoList, studentList.getTotalElements());
  }

  @Override
  public void deleteStudentById(UUID id) {
    profileRepository.deleteById(id);
    logger.debug("Student deleted with id: {}", id);
  }

  @Override
  public ResponseIdDto updateStudentById(UUID id, StudentPostDto dto) {
    Optional<StudentEntity> student = profileRepository.findById(id);
    if (student == null) {
      SyscodeExceptionUtils.throwNotFound(STUDENT_NOT_FOUND);
    }
    student.get().setEmail(dto.getEmail());
    student.get().setName(dto.getName());
    UUID responseID = profileRepository.saveAndFlush(student.get()).getId();
    logger.debug("Student updated with id: {}", responseID);
    return new ResponseIdDto(responseID);
  }

  @Override
  public ResponseIdDto saveStudent(StudentPostDto studentPostDto) {
    StudentEntity student = new StudentEntity(studentPostDto.getName(), studentPostDto.getEmail());
    UUID responseID = profileRepository.save(student).getId();
    logger.debug("Student saved with id: {}", responseID);
    return new ResponseIdDto(responseID);
  }
}
