package com.kickstart.backend.controllers;

import com.kickstart.backend.entities.Freelancer;
import com.kickstart.backend.services.FreelancerService;
import com.kickstart.backend.utils.ResponseEntityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FreelancerController {
    private final FreelancerService freelancerService;

    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping("users/freelancer/{id}")
    public ResponseEntity<Object> getFreelancer(@PathVariable Long id){
        Map<String, Object> response = freelancerService.getFreelancerById(id);
        return ResponseEntityUtil.buildResponseEntity(response);
    }

    @PostMapping("users/freelancer/register")
    public ResponseEntity<Object> postFreelancer(@RequestBody Freelancer freelancer) {
        Map<String, Object> response = freelancerService.postFreelancer(freelancer);
        return ResponseEntityUtil.buildResponseEntity(response);
    }

    @PutMapping("users/freelancer/{id}")
    public ResponseEntity<Object> updateFreelancer(@PathVariable Long id, @RequestBody Freelancer freelancer) {
        Map<String, Object> response = freelancerService.putFreelancer(id, freelancer);
        return ResponseEntityUtil.buildResponseEntity(response);
    }

    @DeleteMapping("users/freelancer/{id}")
    public ResponseEntity<Object> deleteFreelancer(@PathVariable Long id){
        Map<String, Object> response = freelancerService.deleteFreelancer(id);
        return ResponseEntityUtil.buildResponseEntity(response);
    }
}
