package com.onda.aeroops.controller;

import com.onda.aeroops.entity.*;
import com.onda.aeroops.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/referentiels")
@RequiredArgsConstructor
public class ReferentielController {

    private final CompagnieRepository compagnieRepository;
    private final TypeAvionRepository typeAvionRepository;
    private final HandlerRepository handlerRepository;
    private final CategorieAnomalieRepository categorieAnomalieRepository;
    private final ServiceRepository serviceRepository;

    // --- Compagnies ---
    @GetMapping("/compagnies")
    public List<Compagnie> listCompagnies() {
        return compagnieRepository.findAll();
    }

    @PostMapping("/compagnies")
    public ResponseEntity<Compagnie> createCompagnie(@RequestBody Compagnie compagnie) {
        return ResponseEntity.ok(compagnieRepository.save(compagnie));
    }

    @PutMapping("/compagnies/{id}")
    public ResponseEntity<Compagnie> updateCompagnie(@PathVariable Long id, @RequestBody Compagnie updated) {
        Compagnie c = compagnieRepository.findById(id).orElseThrow();
        c.setNom(updated.getNom());
        c.setCode(updated.getCode());
        return ResponseEntity.ok(compagnieRepository.save(c));
    }

    // --- Types d'avions ---
    @GetMapping("/types-avions")
    public List<TypeAvion> listTypesAvions() {
        return typeAvionRepository.findAll();
    }

    @PostMapping("/types-avions")
    public ResponseEntity<TypeAvion> createTypeAvion(@RequestBody TypeAvion typeAvion) {
        return ResponseEntity.ok(typeAvionRepository.save(typeAvion));
    }

    @PutMapping("/types-avions/{id}")
    public ResponseEntity<TypeAvion> updateTypeAvion(@PathVariable Long id, @RequestBody TypeAvion updated) {
        TypeAvion t = typeAvionRepository.findById(id).orElseThrow();
        t.setModele(updated.getModele());
        t.setCapacite(updated.getCapacite());
        return ResponseEntity.ok(typeAvionRepository.save(t));
    }

    // --- Handlers ---
    @GetMapping("/handlers")
    public List<Handler> listHandlers() {
        return handlerRepository.findAll();
    }

    @PostMapping("/handlers")
    public ResponseEntity<Handler> createHandler(@RequestBody Handler handler) {
        return ResponseEntity.ok(handlerRepository.save(handler));
    }

    @PutMapping("/handlers/{id}")
    public ResponseEntity<Handler> updateHandler(@PathVariable Long id, @RequestBody Handler updated) {
        Handler h = handlerRepository.findById(id).orElseThrow();
        h.setNom(updated.getNom());
        h.setContact(updated.getContact());
        return ResponseEntity.ok(handlerRepository.save(h));
    }

    // --- Catégories d'anomalies ---
    @GetMapping("/categories-anomalies")
    public List<CategorieAnomalie> listCategoriesAnomalies() {
        return categorieAnomalieRepository.findAll();
    }

    @PostMapping("/categories-anomalies")
    public ResponseEntity<CategorieAnomalie> createCategorieAnomalie(@RequestBody CategorieAnomalie categorie) {
        return ResponseEntity.ok(categorieAnomalieRepository.save(categorie));
    }

    // --- Services ---
    @GetMapping("/services")
    public List<Service> listServices() {
        return serviceRepository.findAll();
    }
}