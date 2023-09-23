package com.syscode.syscode.test.service;

import com.syscode.syscode.test.common.dto.ResponseIdDto;
import com.syscode.syscode.test.common.dto.StudentListDto;
import com.syscode.syscode.test.common.dto.StudentPostDto;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {

  void deleteStudentById(UUID id);

  ResponseIdDto updateStudentById(UUID id, StudentPostDto dto);

  ResponseIdDto saveStudent(StudentPostDto studentPostDto);

  StudentListDto getStudentListByFilter(Pageable pageable);
}
