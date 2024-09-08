package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employer")
@EqualsAndHashCode(callSuper = true)
public class Employer extends User{
    private String organisationType;
    private String organisationName;
    private String numberOfEmployees;
    private String sector;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> skillsNeeded;
    private String websiteUrl;

    @OneToMany(mappedBy = "ownerId")
    private List<Work> work;
}
