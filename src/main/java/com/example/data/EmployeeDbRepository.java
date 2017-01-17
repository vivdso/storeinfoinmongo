package com.example.data;

import com.example.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by vivek on 1/15/2017.
 */
public interface EmployeeDbRepository extends MongoRepository<Employee,String> {
}
