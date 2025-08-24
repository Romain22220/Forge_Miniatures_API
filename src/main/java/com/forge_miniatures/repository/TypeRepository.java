package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findTypeById(Long Id);
    Optional<Type> findTypeByName(String name);
}
