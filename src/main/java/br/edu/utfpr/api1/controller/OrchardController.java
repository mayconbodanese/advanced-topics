package br.edu.utfpr.api1.controller;

import br.edu.utfpr.api1.dto.OrchardDto;
import br.edu.utfpr.api1.model.Orchard;
import br.edu.utfpr.api1.service.OrchardService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orchards")
@RequiredArgsConstructor
public class OrchardController {

    private final OrchardService orchardService;

    @GetMapping
    public List<Orchard> getAll() {
        return orchardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrchardById(@PathVariable Long id) {
    try {
        Orchard orchard = orchardService.findById(id);
        return ResponseEntity.ok(orchard);
    } catch (EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

    @PostMapping
    public ResponseEntity<Orchard> create(@RequestBody OrchardDto orchard) {
        return ResponseEntity.ok(orchardService.createOrchard(orchard));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orchard> update(@PathVariable Long id, @RequestBody Orchard orchard) {
        return ResponseEntity.ok(orchardService.update(id, orchard));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            orchardService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
