package com.kickstart.backend.controllers;

import com.kickstart.backend.entities.Freelancer;
import com.kickstart.backend.services.FreelancerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FreelancerController {
    private final FreelancerService freelancerService;

    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping("users/freelancer/{id}")
    public ResponseEntity<Freelancer> getFreelancer(@PathVariable Long id){
        return freelancerService.getFreelancerById(id);
    }

    @PostMapping("users/freelancer/register")
    public ResponseEntity<String> postFreelancer(@RequestBody Freelancer freelancer) {
        return freelancerService.postFreelancer(freelancer);
    }

    @PutMapping("users/freelancer/{id}")
    public ResponseEntity<String> updateFreelancer(@PathVariable Long id, @RequestBody Freelancer freelancer) {
        return freelancerService.putFreelancer(id, freelancer);
    }

    @DeleteMapping("users/freelancer/{id}")
    public ResponseEntity<String> deleteFreelancer(@PathVariable Long id){
        return freelancerService.deleteFreelancer(id);
    }
}
