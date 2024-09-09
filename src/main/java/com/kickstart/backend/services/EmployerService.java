package com.kickstart.backend.services;

import com.kickstart.backend.entities.Employer;
import com.kickstart.backend.repository.EmployerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final Map<String, String> message = new HashMap<>();
    private final Map<String, Object> response = new HashMap<>();

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Map<String, Object> getEmployerById(Long id) {
        try {
            Employer employerData = employerRepository.findById(id).orElse(null);
            if (employerData == null) {
                message.put("message", "Employer not found");
                response.put("object", message);
                response.put("status", 404);
            } else {
                response.put("object", employerData);
                response.put("status", 200);
            }
        } catch (DataIntegrityViolationException e) {
            message.put("message", "Data integrity violation occurred: " + e.getMessage());
            response.put("object", message);
            response.put("status", 400);
        } catch (Exception e) {
            message.put("message", "Internal Server Error: " + e.getMessage());
            response.put("object", message);
            response.put("status", 500);
        }
        return response;
    }

    public Map<String, Object> postEmployer(Employer employer) {
        try {
            employerRepository.save(employer);
            message.put("message", "Data added successfully");
            response.put("object", message);
            response.put("status", 201);
        } catch (DataIntegrityViolationException e) {
            message.put("message", "Data integrity violation occurred: " + e.getMessage());
            response.put("object", message);
            response.put("status", 400);
        } catch (Exception e) {
            message.put("message", "Internal Server Error: " + e.getMessage());
            response.put("object", message);
            response.put("status", 500);
        }
        return response;
    }

    public Map<String, Object> putEmployer(Long id, Employer employer) {
        try {
            if (!employerRepository.existsById(id)) {
                message.put("message", "Data not found");
                response.put("object", message);
                response.put("status", 404);
                return response;
            }
            employer.setId(id);
            employerRepository.save(employer);
            message.put("message", "Data updated successfully");
            response.put("object", message);
            response.put("status", 200);
        } catch (DataIntegrityViolationException e) {
            message.put("message", "Data integrity violation occurred: " + e.getMessage());
            response.put("object", message);
            response.put("status", 400);
        } catch (Exception e) {
            message.put("message", "Internal Server Error: " + e.getMessage());
            response.put("object", message);
            response.put("status", 500);
        }
        return response;
    }

    public Map<String, Object> deleteEmployer(Long id) {
        try {
            if (!employerRepository.existsById(id)) {
                message.put("message", "Data not found");
                response.put("object", message);
                response.put("status", 404);
                return response;
            }
            employerRepository.deleteById(id);
            message.put("message", "Data deleted successfully");
            response.put("object", message);
            response.put("status", 200);
        } catch (DataIntegrityViolationException e) {
            message.put("message", "Data integrity violation occurred: " + e.getMessage());
            response.put("object", message);
            response.put("status", 400);
        } catch (Exception e) {
            message.put("message", "Internal Server Error: " + e.getMessage());
            response.put("object", message);
            response.put("status", 500);
        }
        return response;
    }
}
