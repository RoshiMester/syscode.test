package com.syscode.syscode.test.controller;

import com.syscode.syscode.test.common.dto.AddressDto;
import com.syscode.syscode.test.common.exception.handler.SyscodeExceptionHandler;
import com.syscode.syscode.test.service.AddressService;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.syscode.syscode.test.common.constant.Constant.API_ADDRESS;
import static com.syscode.syscode.test.common.constant.Constant.API_PATH;
import static com.syscode.syscode.test.common.constant.Constant.API_VERSION_PATH_V1;

@RestController
@RequestMapping(API_PATH + API_VERSION_PATH_V1 + API_ADDRESS)
@Validated
@Timed
public class AddressController extends SyscodeExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDto> getRandomAddress() {
        logger.info("Run random address generator.");
        return ResponseEntity.ok().body(addressService.getRandomAddress());
    }
}
