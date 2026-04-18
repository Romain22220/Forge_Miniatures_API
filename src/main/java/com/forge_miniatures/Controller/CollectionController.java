package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.CollectionDTO;
import com.forge_miniatures.service.CollectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("/{userId}/{collectionId}")
    public CollectionDTO getCollection(@PathVariable Long userId, @PathVariable Long collectionId) {
        return ResponseEntity.ok(collectionService.getCollection(userId, collectionId)).getBody();
    }
}
