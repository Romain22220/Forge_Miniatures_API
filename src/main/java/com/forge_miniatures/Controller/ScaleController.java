package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.ScaleDTO;
import com.forge_miniatures.service.ScaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scales")
@RequiredArgsConstructor
public class ScaleController {
    private final ScaleService scaleService;

    @GetMapping("/{id}")
    public ResponseEntity<ScaleDTO> getScale(@PathVariable Long id) {
        return ResponseEntity.ok(scaleService.getScaleById(id));
    }

    @PostMapping
    public ResponseEntity<ScaleDTO> createScale(@RequestBody ScaleDTO scaleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scaleService.createScale(scaleDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScaleDTO>> getAllScale() {
        return ResponseEntity.ok(scaleService.getAllScales());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteScale(@PathVariable Long id) {
        scaleService.deleteScaleById(id);
        return ResponseEntity.noContent().build();
    }
}
