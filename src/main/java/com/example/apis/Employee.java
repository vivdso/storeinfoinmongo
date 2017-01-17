package com.example.apis;

import com.example.data.EmployeeDbRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.List;

/**
 * Created by vivek on 1/15/2017.
 */
@RestController
@RequestMapping("/v1/employee")
public class Employee {

    @Autowired
    private EmployeeDbRepository _employeeRepo;

    @RequestMapping(method= RequestMethod.GET)
    public List<com.example.domain.Employee> Get(){


        return _employeeRepo.findAll();
    }
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity Post(@RequestParam("employeePic") MultipartFile employeePic, @RequestParam String firstName, @RequestParam String lastName) throws IOException {

        String contentType =employeePic.getContentType();
        if (!(contentType.contains("jpeg"))){
            return new ResponseEntity(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        com.example.domain.Employee employee = new com.example.domain.Employee(null,firstName,lastName, new Binary(employeePic.getBytes()));
        _employeeRepo.save(employee);
        return new ResponseEntity(HttpStatus.OK);

    }
}
