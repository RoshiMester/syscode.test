package com.syscode.syscode.test.service;

import com.github.javafaker.Faker;
import com.syscode.syscode.test.common.dto.AddressDto;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
  private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

  @Autowired
  public AddressServiceImpl() {}

  @Override
  public AddressDto getRandomAddress() {
    Faker faker = new Faker();
    String streetName = faker.address().streetName();
    String number = faker.address().buildingNumber();
    String city = faker.address().city();
    String country = faker.address().country();
    String address = country + " " + city + " " + streetName + " " + number;
    logger.debug("Random address: {}", address);
    return new AddressDto(UUID.randomUUID(), address);
  }
}
