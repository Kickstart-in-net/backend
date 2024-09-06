package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "work")
@Inheritance(strategy = InheritanceType.JOINED)
public class Work {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "assigned")
    private Freelancer assignedId;

    @OneToOne(mappedBy = "owner")
    private Employer ownerId;

    private String title;
    private String description;
    private String budget;
    private LocalDate deadline;

    @OneToMany(mappedBy = "skilldId")
    private List<Skill> skillIds;
}
