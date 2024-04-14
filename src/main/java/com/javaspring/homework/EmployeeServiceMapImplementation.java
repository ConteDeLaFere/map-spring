package com.javaspring.homework;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceMapImplementation implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceMapImplementation() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName);
        employees.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employees.get(fullName);
        employees.remove(fullName);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        if (employees.containsKey(fullName)) {
            return employees.get(fullName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
