package com.kickstart.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chats")
public class Chat {
    @MongoId
    private String id;
    private List<Message> messageList;
    private Long freelancerId;
    private Long employerId;
}
