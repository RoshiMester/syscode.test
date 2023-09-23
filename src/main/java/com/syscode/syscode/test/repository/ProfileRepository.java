package com.syscode.syscode.test.repository;

import com.syscode.syscode.test.domain.StudentEntity;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<StudentEntity, UUID> {
  Page<StudentEntity> findAll(Pageable pageable);
}
