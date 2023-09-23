package com.syscode.syscode.test.common.exception.util;

import com.syscode.syscode.test.common.exception.StudentFormProperty;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentFormPropertyCreator {
  private static final String EMPTY_STRING = "";
  private static final String SPACE = " ";
  private static final String DOT = ".";
  private static final String DOUBLE_DOT = ":";
  private static final String COMMA = ",";

  private StudentFormPropertyCreator() {}

  public static List<StudentFormProperty> createPropertyFromErrorMsg(String msg) {
    return (List)
        Stream.of(msg.replaceAll(" ", ""))
            .map(
                (fullMsg) -> {
                  return fullMsg.split(",");
                })
            .flatMap(Arrays::stream)
            .map(
                (splittedByComma) -> {
                  return splittedByComma.split(":");
                })
            .map(
                (splittedByDoubleDot) -> {
                  return createStudentProperty(splittedByDoubleDot);
                })
            .collect(Collectors.toList());
  }

  private static StudentFormProperty createStudentProperty(String[] fullName) {
    return new StudentFormProperty(fullName[1], getPropertyName(fullName[0]));
  }

  private static String getPropertyName(String fullNameOfTheProperty) {
    int index = fullNameOfTheProperty.lastIndexOf(".") + 1;
    return index == 0
        ? fullNameOfTheProperty
        : fullNameOfTheProperty.substring(index, fullNameOfTheProperty.length());
  }
}
