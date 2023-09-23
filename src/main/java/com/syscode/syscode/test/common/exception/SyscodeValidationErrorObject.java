package com.syscode.syscode.test.common.exception;

import java.util.List;

public class SyscodeValidationErrorObject {
  private final List<SyscodeFormProperty> messages;

  public SyscodeValidationErrorObject(List<SyscodeFormProperty> messages) {
    this.messages = messages;
  }

  public List<SyscodeFormProperty> getMessages() {
    return this.messages;
  }
}
