package com.gabriel.crud.repository;

import com.gabriel.crud.model.CreatorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<CreatorModel, Long> {
}
