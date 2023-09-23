package com.syscode.syscode.test.common.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentListDto {
  private long resultsLength;
  private List<StudentDto> results;

  public StudentListDto(List<StudentDto> dtoList, long totalElements) {
    this.results = dtoList;
    this.resultsLength = totalElements;
  }
}
