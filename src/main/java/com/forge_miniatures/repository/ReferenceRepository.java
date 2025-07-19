package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Article;
import com.forge_miniatures.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference,Integer> {
    Reference findReferenceById(Long Id);
}
