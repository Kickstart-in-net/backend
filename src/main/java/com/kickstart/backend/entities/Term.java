package com.kickstart.backend.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "terms")
public class Term {
    @MongoId
    private String id;
    private String type;

}
@Data
@Document(collection = "terms")
class Deadline{

    private String type;

}