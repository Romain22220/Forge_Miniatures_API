package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReferenceRepository extends JpaRepository<Reference,Integer> {
    Reference findReferenceById(Long Id);
    Optional<Reference> findReferenceByName(String name);
}
