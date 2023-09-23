package com.syscode.syscode.test.common.exception;

import java.util.List;

public class StudentValidationErrorObject {
  private final List<StudentFormProperty> messages;

  public StudentValidationErrorObject(List<StudentFormProperty> messages) {
    this.messages = messages;
  }

  public List<StudentFormProperty> getMessages() {
    return this.messages;
  }
}
