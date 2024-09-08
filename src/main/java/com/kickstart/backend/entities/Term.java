package com.kickstart.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "terms")
public class Term {
    @MongoId
    private String id;
    private Type type;
    private boolean isSatisfied;
    private String body;

    public enum Type {
        DEADLINE,BUDGET,FEATURE
    }
}