package com.gabriel.crud.repository;

import com.gabriel.crud.model.ComicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<ComicModel, Long> {
}
