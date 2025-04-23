package br.edu.utfpr.api1.controller;

import br.edu.utfpr.api1.model.Orchard;
import br.edu.utfpr.api1.service.OrchardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Orchard> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orchardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Orchard> create(@RequestBody Orchard orchard, @RequestParam Long propertyId) {
        return ResponseEntity.ok(orchardService.save(orchard, propertyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orchard> update(@PathVariable Long id, @RequestBody Orchard orchard) {
        return ResponseEntity.ok(orchardService.update(id, orchard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orchardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
