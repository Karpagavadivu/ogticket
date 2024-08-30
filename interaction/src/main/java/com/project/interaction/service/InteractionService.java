package com.project.interaction.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.interaction.entity.InteractionEntity;
import com.project.interaction.repository.InteractionRepository;

@Service
public class InteractionService {

    @Autowired
    private InteractionRepository repository;

    public List<InteractionEntity> findAll() {
        return repository.findAll();
    }

    public Optional<InteractionEntity> findById(String interactionId) {
        return repository.findById(interactionId);
    }

    public InteractionEntity save(InteractionEntity interactionEntity) {
        return repository.save(interactionEntity);
    }

    public void deleteById(String interactionId) {
        repository.deleteById(interactionId);
    }

    // Custom query methods
    public List<InteractionEntity> findRecentInteractions() {
        // Implement custom query logic here, e.g., using @Query annotation or method naming convention
        return null;
    }

    public List<InteractionEntity> findMissingDetails() {
        // Implement custom query logic here
        return null;
    }

    public Object updateInteraction(String interactionId, InteractionEntity interactionEntity) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateInteraction'");
    }
}
