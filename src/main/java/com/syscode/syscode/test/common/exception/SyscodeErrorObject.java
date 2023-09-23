package com.syscode.syscode.test.common.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SyscodeErrorObject {
  public static final String LABEL = "label";
  private final List<Map> messages = new ArrayList();

  public SyscodeErrorObject(String message) {
    this.messages.add(Collections.singletonMap("label", message));
  }

  public SyscodeErrorObject(List<String> messages) {
    Iterator var2 = messages.iterator();

    while (var2.hasNext()) {
      String message = (String) var2.next();
      this.messages.add(Collections.singletonMap("label", message));
    }
  }

  public List<Map> getMessages() {
    return this.messages;
  }
}
