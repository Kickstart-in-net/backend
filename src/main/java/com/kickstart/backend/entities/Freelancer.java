package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="freelancer")
public class Freelancer extends User {
    private String pan;
    private String profession;
    private LocalDate dateOfBirth;
    private String githubURL;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> interests;

    @OneToMany(mappedBy = "projectIds")
    private List<Project> projects;

    @OneToMany(mappedBy = "work")
    private List<Work> works;
}
