package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Subtype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubtypeRepository extends JpaRepository<Subtype, Integer> {
    Optional<Subtype> findSubtypeByName(String name);
}
