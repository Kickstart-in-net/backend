package com.kickstart.backend.services;

import com.kickstart.backend.entities.Freelancer;
import com.kickstart.backend.repository.FreelancerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FreelancerService {
    private final FreelancerRepository freelancerRepository;
    private final Map<String, Object> response = new HashMap<>();
    private final Map<String, String> message = new HashMap<>();

    public FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public Map<String, Object> getFreelancerById(Long id) {
        try {
            Freelancer freelancerData = freelancerRepository.findById(id).orElse(null);
            if (freelancerData == null) {
                message.put("message", "Freelancer not found");
                response.put("object", message);
                response.put("status", 404);
            } else {
                response.put("object", freelancerData);
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

    public Map<String, Object> postFreelancer(Freelancer freelancer) {
        try {
            freelancerRepository.save(freelancer);
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

    public Map<String, Object> putFreelancer(Long id, Freelancer freelancer) {
        try {
            if (!freelancerRepository.existsById(id)) {
                message.put("message", "Data not found");
                response.put("object", message);
                response.put("status", 404);
                return response;
            }
            freelancer.setId(id);
            freelancerRepository.save(freelancer);
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

    public Map<String, Object> deleteFreelancer(Long id) {
        try {
            if (!freelancerRepository.existsById(id)) {
                message.put("message", "Data not found");
                response.put("object", message);
                response.put("status", 404);
                return response;
            }
            freelancerRepository.deleteById(id);
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
