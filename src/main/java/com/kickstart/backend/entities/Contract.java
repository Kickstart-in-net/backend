package com.kickstart.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "contract")
public class Contract extends Work{
    private List<String> termId;
    private LocalDate dateCreated;
    private boolean isCompleted;
    private String employerSign;
    private String freelancerSign;
}
