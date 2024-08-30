package com.project.interaction.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.interaction.entity.InteractionEntity;
import com.project.interaction.service.InteractionService;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    @Autowired
    private InteractionService service;

    @GetMapping
    public List<InteractionEntity> getAllInteractions() {
        return service.findAll();
    }

    @GetMapping("/{interactionId}")
    public ResponseEntity<InteractionEntity> getInteractionById(@PathVariable String interactionId) {
        Optional<InteractionEntity> interaction = service.findById(interactionId);
        return interaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public InteractionEntity createInteraction(@RequestBody InteractionEntity interactionEntity) {
        return service.save(interactionEntity);
    }

    @PutMapping("/{interactionId}")
    public ResponseEntity<InteractionEntity> updateInteraction(
            @PathVariable String interactionId, @RequestBody InteractionEntity interactionEntity) {
        if (!service.findById(interactionId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        interactionEntity.setInteractionId(interactionId);
        return ResponseEntity.ok(service.save(interactionEntity));
    }

    @DeleteMapping("/{interactionId}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable String interactionId) {
        if (!service.findById(interactionId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(interactionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recent")
    public List<InteractionEntity> getRecentInteractions() {
        return service.findRecentInteractions();
    }

    @GetMapping("/missing-details")
    public List<InteractionEntity> getMissingDetails() {
        return service.findMissingDetails();
    }
}
