package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Integer> {
}
