package com.taske.taskDelat.controller;

import com.taske.taskDelat.model.GeneInfo;
import com.taske.taskDelat.model.NewGeneInfo;
import com.taske.taskDelat.service.GeneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gene")
@CrossOrigin(origins = "*")
public class GeneController {

    private final GeneService geneService;

    public GeneController(GeneService geneService) {
        this.geneService = geneService;
    }


    @GetMapping("/by-phenotype")
    public ResponseEntity<?> getPhenotype(@RequestParam String phenotypes){
        if (phenotypes == null || phenotypes.isBlank()) {
            return ResponseEntity

                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Parameter 'geneSymbol' is required\"}");
        }
        NewGeneInfo type = geneService.findByPhenotype(phenotypes);
        if (type == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Gene not found\"}");
        }

        return ResponseEntity.ok(type);
    }

    @GetMapping("/by-symbol")
    public ResponseEntity<?> getGeneInfo(@RequestParam String geneSymbol) {
        if (geneSymbol == null || geneSymbol.isBlank()) {
            return ResponseEntity

                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Parameter 'geneSymbol' is required\"}");
        }

        GeneInfo result = geneService.findBySymbol(geneSymbol);
        if (result == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Gene not found\"}");
        }

        return ResponseEntity.ok(result);
    }

    // Фильтрация по клинической значимости
    @GetMapping("/by-significance")
    public ResponseEntity<?> getBySignificance(@RequestParam String significance) {
        if (significance == null || significance.isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Parameter 'significance' is required\"}");
        }

        List<GeneInfo> res = geneService.getBySignificance(significance);
        if (res == null || res.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"No genes found for significance: " + significance + "\"}");
        }

        return ResponseEntity.ok(res);
    }

    // Фильтрация по типу сборки (Assembly)
    @GetMapping("/by-assembly")
    public ResponseEntity<?> getByAssembly(@RequestParam String assembly) {
        if (assembly == null || assembly.isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Parameter 'assembly' is required\"}");
        }

        List<GeneInfo> res = geneService.getByAssembly(assembly);
        if (res == null || res.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"No genes found for assembly: " + assembly + "\"}");
        }

        return ResponseEntity.ok(res);
    }
}

