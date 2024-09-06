package com.kickstart.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "badge")
    private List<Badge> badges;
    private String title;
    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Freelancer owner;
    private String description;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> techStack;
    private String gitHubRepoUrl;
    private String thumbnailUrl;
//MongoDb ref
    private String folderId;
}
