package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.collection.CollectionDTO;
import com.forge_miniatures.dto.collection.CreateCollectionDTO;
import com.forge_miniatures.service.client.CollectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/me/all")
    public ResponseEntity<List<CollectionDTO>> getAllCollections(Authentication authentication) {
        return ResponseEntity.ok(collectionService.getAllCollections(authentication));
    }

    @PostMapping("/me/create")
    public ResponseEntity<CollectionDTO> createCollection(Authentication authentication, @Valid @RequestBody CreateCollectionDTO collectionDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(collectionService.createCollection(authentication, collectionDTO));
    }

    @DeleteMapping("/me/delete")
    public ResponseEntity<Void> deleteCollection(Authentication authentication, @Valid @RequestBody CollectionDTO collectionDTO) {
        collectionService.deleteCollection(authentication, collectionDTO);
        return ResponseEntity.noContent().build();
    }
}
