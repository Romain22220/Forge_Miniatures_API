package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Scale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScaleRepository extends JpaRepository<Scale,Integer> {
    Scale findScaleById(Long Id);
    Optional<Scale> findScaleByScale(String scale);
    List<Scale> id(Long id);
    void deleteScaleById(Long id);
    boolean existsById(Long id);
}
