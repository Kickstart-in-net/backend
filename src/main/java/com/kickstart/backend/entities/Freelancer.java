package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="freelancer")
@EqualsAndHashCode(callSuper = true)
public class Freelancer extends User {
    private String pan;
    private String profession;
    private LocalDate dateOfBirth;
    private String githubURL;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> interests;

    @OneToMany(mappedBy = "ownerId")
    private List<Project> projects;

    @OneToMany(mappedBy = "assignedId")
    private List<Work> works;
}
