package com.syscode.syscode.test.service;

import com.syscode.syscode.test.common.dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

  AddressDto getRandomAddress();
}
