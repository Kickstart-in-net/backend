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

    public FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public Map<String,Object> getFreelancerById(Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Freelancer freelancerData = freelancerRepository.findById(id).orElse(null);
            response.put("object", freelancerData);
            response.put("status",200);
            return response;
        } catch (DataIntegrityViolationException e) {
            response.put("object", "{\"message\":\"Data integrity violation occurred:"+ e.getMessage()+"\"}");
            response.put("status",400);
            return response;
        } catch (Exception e) {
            response.put("object", "{\"message\":\"Internal Server error: "+ e.getMessage()+"\"}");
            response.put("status",500);
            return response;
        }
    }

    public Map<String,Object> postFreelancer(Freelancer freelancer) {
        Map<String, Object> response = new HashMap<>();
        try {
            freelancerRepository.save(freelancer);
            response.put("object", "{\"message\":\"Data added successfully\"}");
            response.put("status",201);
            return response;
        } catch (DataIntegrityViolationException e) {
            response.put("object", "{\"message\":\"Data integrity violation occurred:"+ e.getMessage()+"\"}");
            response.put("status",400);
            return response;
        } catch (Exception e) {
            response.put("object", "{\"message\":\"Internal Server error: "+ e.getMessage()+"\"}");
            response.put("status",500);
            return response;
        }
    }

    public Map<String,Object> putFreelancer(Long id, Freelancer freelancer) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (!freelancerRepository.existsById(id)) {
                response.put("object","{\"message\":\"Data Not Found\"}");
                response.put("status",404);
                return response;
            }
            // Set the id of the freelancer object to the one being updated
            freelancer.setId(id);
            freelancerRepository.save(freelancer);
            response.put("object","{\"message\":\"Data Updated Successfully\"}");
            response.put("status",200);
            return response;
        } catch (DataIntegrityViolationException e) {
            response.put("object", "{\"message\":\"Data integrity violation occurred:"+ e.getMessage()+"\"}");
            response.put("status",400);
            return response;
        } catch (Exception e) {
            response.put("object", "{\"message\":\"Internal Server error: "+ e.getMessage()+"\"}");
            response.put("status",500);
            return response;
        }
    }

    public Map<String,Object> deleteFreelancer(Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (!freelancerRepository.existsById(id)) {
                response.put("object","{\"message\":\"Data Not Found\"}");
                response.put("status",404);
                return response;
            }
            freelancerRepository.deleteById(id);
            response.put("object","{\"message\":\"Data Deleted Successfully\"}");
            response.put("status",200);
            return response;
        } catch (DataIntegrityViolationException e) {
            response.put("object", "{\"message\":\"Data integrity violation occurred:"+ e.getMessage()+"\"}");
            response.put("status",400);
            return response;
        } catch (Exception e) {
            response.put("object", "{\"message\":\"Internal Server error: "+ e.getMessage()+"\"}");
            response.put("status",500);
            return response;
        }
    }
}
