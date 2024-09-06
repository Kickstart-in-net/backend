package com.kickstart.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "projectFolders")
public class Folder {
    @MongoId
    private String id;
    private String name;
    private LocalDateTime createdAt;
    private List<File> files; // List of files in this folder
    private List<Folder> subfolders; // List of subfolders in this folder

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class File {
        private String fileId;
        private String name;
        private long size; // Size in bytes
        private String contentType; // MIME type
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String content; // Optional field to store file content (if needed)
    }
}
