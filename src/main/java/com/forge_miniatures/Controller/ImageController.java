package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.ArticleImageDTO;
import com.forge_miniatures.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @PostMapping("/upload/{articleId}")
    public ResponseEntity<?> uploadImage(
            @PathVariable Long articleId,
            @RequestParam("file") MultipartFile file) {

        try {
            ArticleImageDTO saved = imageService.uploadImage(articleId, file);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de l'upload : " + e.getMessage());
        }
    }
}
