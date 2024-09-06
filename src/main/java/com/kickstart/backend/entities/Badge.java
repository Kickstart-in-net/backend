package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "badge")
public class Badge {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate createdDate;
    private Integer marks;
    @OneToOne(mappedBy = "projectId")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "skillId")
    private Skill skill;
}
