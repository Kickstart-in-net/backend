package com.kickstart.backend.controllers;

import com.kickstart.backend.entities.Freelancer;
import com.kickstart.backend.services.FreelancerService;
import org.springframework.http.HttpStatus;
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
        Map<String,Object> response = freelancerService.getFreelancerById(id);
        return getObjectResponseEntity(response);
    }

    @PostMapping("users/freelancer/register")
    public ResponseEntity<Object> postFreelancer(@RequestBody Freelancer freelancer) {
        Map<String,Object> response = freelancerService.postFreelancer(freelancer);
        return getObjectResponseEntity(response);
    }

    @PutMapping("users/freelancer/{id}")
    public ResponseEntity<Object> updateFreelancer(@PathVariable Long id, @RequestBody Freelancer freelancer) {
        Map<String,Object> response = freelancerService.putFreelancer(id,freelancer);
        return getObjectResponseEntity(response);
    }

    @DeleteMapping("users/freelancer/{id}")
    public ResponseEntity<Object> deleteFreelancer(@PathVariable Long id){
        Map<String,Object> response = freelancerService.deleteFreelancer(id);
        return getObjectResponseEntity(response);
    }

    private ResponseEntity<Object> getObjectResponseEntity(Map<String, Object> response) {
        if(response.get("status").equals(200))
            return new ResponseEntity<>(response.get("object"), HttpStatus.OK);
        else if(response.get("status").equals(201))
            return new ResponseEntity<>(response.get("object"),HttpStatus.CREATED);
        else if(response.get("status").equals(400))
            return new ResponseEntity<>(response.get("object"),HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(response.get("object"),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
