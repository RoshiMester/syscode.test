package com.syscode.syscode.test.common.dto;

import jakarta.validation.constraints.Email;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
  private UUID id;
  private String name;

  @Email(message = "error")
  private String email;
}
