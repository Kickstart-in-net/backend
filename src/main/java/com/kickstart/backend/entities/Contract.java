package com.kickstart.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contract")
@EqualsAndHashCode(callSuper = true)
public class Contract extends Work{
    private List<String> termId;
    private LocalDate dateCreated;
    private boolean isCompleted;
    private String employerSign;
    private String freelancerSign;
}
