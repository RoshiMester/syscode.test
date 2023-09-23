package com.syscode.syscode.test.common.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

public class StudentException extends RuntimeException {
  private final List<String> messages = new ArrayList();
  private final HttpStatus httpStatus;

  public StudentException(String label, HttpStatus httpstatus) {
    this.messages.add(label);
    this.httpStatus = httpstatus;
  }

  public List<String> getMessages() {
    return this.messages;
  }

  public HttpStatus getHttpStatus() {
    return this.httpStatus;
  }
}
