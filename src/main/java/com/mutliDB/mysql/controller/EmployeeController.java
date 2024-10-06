package com.mutliDB.mysql.controller;

import com.mutliDB.mysql.entities.Employee;
import com.mutliDB.mysql.repo.EmployeeRepo;
import com.mutliDB.postgres.entities.Vehicle;
import com.mutliDB.postgres.repo.VehicleRepo;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepository;
    @Autowired
    private VehicleRepo vehicleRepo;

    // Get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Create employee REST API
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get employee by id REST API
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return ResponseEntity.ok(employee);
    }

    // Update employee REST API
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmailId(employeeDetails.getEmailId());
            // Update other fields as needed
            Employee updatedEmployee = employeeRepository.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        }

        return ResponseEntity.ok(null); // Or you could return a 404 response if preferred
    }

    // Delete employee REST API
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employeeRepository.delete(employee);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.ok(new HashMap<>()); // Or you could return a 404 response if preferred
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getEmployeeById(@PathVariable int id) {
        Vehicle vehicle = vehicleRepo.findById(id).orElse(null);
        return ResponseEntity.ok(vehicle);
    }
    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return  vehicleRepo.save(vehicle);
    }
}
