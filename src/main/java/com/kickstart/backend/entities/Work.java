package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "work")
@Inheritance(strategy = InheritanceType.JOINED)
public class Work {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignedId")
    private Freelancer assignedId;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Employer ownerId;

    private String title;
    private String description;
    private String budget;
    private LocalDate deadline;

    @OneToMany(mappedBy = "workId")
    private List<Skill> skillIds;
}
