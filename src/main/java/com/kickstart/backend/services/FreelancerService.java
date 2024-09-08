package com.kickstart.backend.services;

import com.kickstart.backend.entities.Freelancer;
import com.kickstart.backend.repository.FreelancerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FreelancerService {
    private final FreelancerRepository freelancerRepository;

    public FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public ResponseEntity<Freelancer> getFreelancerById(Long id) {
        try {
            Freelancer freelancerData = freelancerRepository.findById(id).orElse(null);
            return new ResponseEntity<>(freelancerData, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> postFreelancer(Freelancer freelancer) {
        try {
            freelancerRepository.save(freelancer);
            return new ResponseEntity<>("Data added successfully", HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> putFreelancer(Long id, Freelancer freelancer) {
        try {
            if (!freelancerRepository.existsById(id)) {
                return new ResponseEntity<>("Freelancer not found", HttpStatus.NOT_FOUND);
            }
            // Set the id of the freelancer object to the one being updated
            freelancer.setId(id);
            freelancerRepository.save(freelancer);
            return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteFreelancer(Long id) {
        try {
            if (!freelancerRepository.existsById(id)) {
                return new ResponseEntity<>("Freelancer not found", HttpStatus.NOT_FOUND);
            }
            freelancerRepository.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
