package com.satendra.mdcfilter.controller;

import com.satendra.mdcfilter.service.EmployeeService;
import com.satendra.mdcfilter.vo.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static  final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("test")
    public SuccessResponse test(){

        logger.info("controller executed");
        employeeService.addEmployee();
        SuccessResponse sucessResponse = new SuccessResponse();
        sucessResponse.setMessage("operation insertion performed");
        return sucessResponse;
    }
}
