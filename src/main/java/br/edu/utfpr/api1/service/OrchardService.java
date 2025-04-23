package br.edu.utfpr.api1.service;

import br.edu.utfpr.api1.model.Orchard;
import br.edu.utfpr.api1.model.Property;
import br.edu.utfpr.api1.repository.OrchardRepository;
import br.edu.utfpr.api1.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrchardService {

    private final OrchardRepository orchardRepository;
    private final PropertyRepository propertyRepository;

    public List<Orchard> findAll() {
        return orchardRepository.findAll();
    }

    public Orchard findById(Long id) {
        return orchardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Orchard not found with ID: " + id));
    }

    public Orchard save(Orchard orchard, Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new EntityNotFoundException("Property not found with ID: " + propertyId));
        orchard.setProperty(property);
        return orchardRepository.save(orchard);
    }

    public Orchard update(Long id, Orchard orchardDetails) {
        Orchard orchard = findById(id);
        orchard.setLatitude(orchardDetails.getLatitude());
        orchard.setLongitude(orchardDetails.getLongitude());
        return orchardRepository.save(orchard);
    }

    public void delete(Long id) {
        Orchard orchard = findById(id);
        orchardRepository.delete(orchard);
    }
}