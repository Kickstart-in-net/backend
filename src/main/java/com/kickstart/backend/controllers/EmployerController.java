package com.kickstart.backend.controllers;

import com.kickstart.backend.entities.Employer;
import com.kickstart.backend.services.EmployerService;
import com.kickstart.backend.utils.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("users/employer/{id}")
    public ResponseEntity<Object> getEmployer(@PathVariable Long id) {
        Map<String, Object> response = employerService.getEmployerById(id);
        return ResponseEntityUtil.buildResponseEntity(response);
    }

    @PostMapping("users/employer/register")
    public ResponseEntity<Object> postEmployer(@RequestBody Employer employer) {
        Map<String, Object> response = employerService.postEmployer(employer);
        return ResponseEntityUtil.buildResponseEntity(response);
    }

    @PutMapping("users/employer/{id}")
    public ResponseEntity<Object> updateEmployer(@PathVariable Long id, @RequestBody Employer employer) {
        Map<String, Object> response = employerService.putEmployer(id, employer);
        return ResponseEntityUtil.buildResponseEntity(response);
    }

    @DeleteMapping("users/employer/{id}")
    public ResponseEntity<Object> deleteEmployer(@PathVariable Long id) {
        Map<String, Object> response = employerService.deleteEmployer(id);
        return ResponseEntityUtil.buildResponseEntity(response);
    }
}
