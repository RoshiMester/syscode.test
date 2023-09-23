package com.syscode.syscode.test.service;

import com.syscode.syscode.test.common.dto.AddressDto;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.Assert.assertNotNull;

class AddressServiceImplTest {

  @InjectMocks AddressServiceImpl addressService;

  @Test
  void testGetRandomAddress() {
    MockitoAnnotations.openMocks(this);
    AddressDto addressDto = addressService.getRandomAddress();
    assertNotNull(addressDto);
    assertNotNull(addressDto.getId());
    try {
      UUID.fromString(addressDto.getId().toString());
    } catch (IllegalArgumentException e) {
      fail("Invalid UUID format");
    }
  }
}
