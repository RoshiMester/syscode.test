package com.syscode.syscode.test.controller;

import com.syscode.syscode.test.common.dto.ResponseIdDto;
import com.syscode.syscode.test.common.dto.StudentListDto;
import com.syscode.syscode.test.common.dto.StudentPostDto;
import com.syscode.syscode.test.common.exception.handler.SyscodeExceptionHandler;
import com.syscode.syscode.test.service.ProfileService;
import jakarta.validation.Valid;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.annotation.Timed;

import static com.syscode.syscode.test.common.constant.Constant.API_PATH;
import static com.syscode.syscode.test.common.constant.Constant.API_PROFILE;
import static com.syscode.syscode.test.common.constant.Constant.API_VERSION_PATH_V1;

@RestController
@RequestMapping(API_PATH + API_VERSION_PATH_V1 + API_PROFILE)
@Validated
@Timed
public class ProfileController extends SyscodeExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteStudent(@PathVariable UUID id) {
        logger.info("Delete student -  id: {}", id);
        profileService.deleteStudentById(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudentById(
            @PathVariable UUID id,
            @Valid @RequestBody StudentPostDto studentPostDto) {
        logger.info("Update student  - id : {}", id);
        return ResponseEntity.ok().body(profileService.updateStudentById(id, studentPostDto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentListDto> pageableStudentList(Pageable pageable) {
        logger.info("Get student list - page: {}", pageable);
        return ResponseEntity.ok().body(profileService.getStudentListByFilter(pageable));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseIdDto> saveStudent(
            @RequestBody @Valid StudentPostDto studentPostDto) {
        logger.info("Save student - studentPostDto email: {}, name: {}",
                studentPostDto.getEmail(),
                studentPostDto.getName());
        ResponseIdDto id = profileService.saveStudent(studentPostDto);
        return ResponseEntity.ok().body(id);
    }
}
