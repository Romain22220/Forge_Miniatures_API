package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findStatusById(Long Id);
    Optional<Status> findStatusByStatut(String statut);
}
