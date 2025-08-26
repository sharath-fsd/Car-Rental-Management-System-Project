package com.example.Carapp.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class uploads {

    private static final String UPLOAD_DIR = "uploads";

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Ensure upload directory exists
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists() && !dir.mkdirs()) {
                return ResponseEntity.status(500).body("❌ Could not create upload directory");
            }

            // Sanitize and generate unique filename
            String originalFilename = file.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
            String filename = System.currentTimeMillis() + "_" + originalFilename;
            Path path = Paths.get(UPLOAD_DIR, filename);

            // Save file
            Files.write(path, file.getBytes());

            return ResponseEntity.ok(filename);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("❌ Upload failed");
        }
    }
}
