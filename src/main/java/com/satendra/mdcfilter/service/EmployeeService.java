package com.satendra.mdcfilter.service;

import com.satendra.mdcfilter.dao.EmployeeDao;
import com.satendra.mdcfilter.entity.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(){
        logger.info("adding employee start");
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeName("satendra");
        employeeEntity.setEmployeeDepartment("spring");
        employeeDao.save(employeeEntity);
        logger.info("adding employee done");
    }
}
