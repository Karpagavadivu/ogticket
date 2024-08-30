package com.project.interaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.interaction.entity.InteractionEntity;




@Repository
public interface InteractionRepository extends JpaRepository<InteractionEntity, String> {



}
