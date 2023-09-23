package com.syscode.syscode.test.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
  public static Object convertObjToDto(Object o, TypeReference ref) {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.convertValue(o, ref);
  }
}
