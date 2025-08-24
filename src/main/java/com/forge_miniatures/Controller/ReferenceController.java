package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.ReferenceDTO;
import com.forge_miniatures.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/references")
@RequiredArgsConstructor
public class ReferenceController {
    private final ReferenceService referenceService;

    @PostMapping("/create")
    public ResponseEntity<ReferenceDTO> createReference(@RequestBody ReferenceDTO referenceDTO) {
        return ResponseEntity.ok(referenceService.createReference(referenceDTO));
    }

    @GetMapping("/id")
    public ResponseEntity<ReferenceDTO>  findReferenceById(@RequestParam Long id) {
        return ResponseEntity.ok(referenceService.findReferenceById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReferenceDTO>>  findAllReference() {
        return ResponseEntity.ok(referenceService.findAllReferences());
    }

    @PutMapping("/id/update")
    public ResponseEntity<ReferenceDTO> updateReference(@RequestBody ReferenceDTO referenceDTO) {
        return ResponseEntity.ok(referenceService.updateReference(referenceDTO));
    }


}