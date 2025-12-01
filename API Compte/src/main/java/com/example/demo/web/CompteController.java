package com.example.demo.web;

import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes") // Matches your React API_BASE_URL + /comptes
@CrossOrigin(origins = "*") // Allows your React app (on port 3000) to access this API
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    // GET /api/comptes
    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    // GET /api/comptes/{id}
    @GetMapping("/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // POST /api/comptes
    @PostMapping
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    // DELETE /api/comptes/{id}
    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}