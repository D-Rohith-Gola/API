package com.testdocker1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testdocker1.entity.Employee;

@Repository
public interface TestDAOInterface extends JpaRepository<Employee, String>{

}
