package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Contain;
import com.forge_miniatures.entity.ContainId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainRepository extends JpaRepository<Contain, ContainId> {
}
