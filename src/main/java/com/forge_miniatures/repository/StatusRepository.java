package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findStatusById(Long Id);
}
