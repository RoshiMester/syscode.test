package com.syscode.syscode.test.common.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentPostDto {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
}
