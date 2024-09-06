package com.kickstart.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employer")
public class Employer extends User{
    private String organisationType;
    private String organisationName;
    private String numberOfEmployees;
    private String sector;
    private List<String> skillsNeeded;
    private String websiteUrl;
}
