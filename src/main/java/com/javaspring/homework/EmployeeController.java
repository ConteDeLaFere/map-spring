package com.javaspring.homework;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
