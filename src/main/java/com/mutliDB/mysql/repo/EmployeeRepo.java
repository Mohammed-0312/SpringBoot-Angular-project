package com.mutliDB.mysql.repo;

import com.mutliDB.mysql.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
