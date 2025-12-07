package com.taske.taskDelat.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taske.taskDelat.model.GeneInfo;
import com.taske.taskDelat.model.GeneInfoJson;
import com.taske.taskDelat.model.NewGeneInfo;
import com.taske.taskDelat.service.GeneService;
import com.taske.taskDelat.strategy.StrategyAnalysis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/gene")
@CrossOrigin(origins = "*")
public class GeneController {

    private final GeneService geneService;

    public GeneController(GeneService geneService) {
        this.geneService = geneService;
    }


    @GetMapping("/analisis/check-consistency")
    public StrategyAnalysis  check(@Parameter(
            description = "Анализ и сходства по диагнозу",
            example = "Пневмония: боль в животе, диарея"
    )@RequestParam String diagnosis,@RequestParam String phenotype){

        return geneService.getByDiagnosis(diagnosis,phenotype);

    }

    @GetMapping("/by-phenotype")
    public ResponseEntity<?> getPhenotype(@Parameter(
            description = "Поиск по фенотипу",
            example = "желтушность кожи, темная моча"
    )@RequestParam String phenotypes){
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
    /*@GetMapping("/by-assembly")
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
    }*/


    @GetMapping("/by-geneSymbol")
    public ResponseEntity<?> getGene(@Parameter(
            description = "Название ген (например KMT2D)",
            example = "KMT2D"
    ) @RequestParam  String gene) throws IOException {
        GeneInfoJson res = geneService.getByGeneSymbolAtJson(gene);
        if (res == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Gene not found\"}");
        }
        return ResponseEntity.ok(res);
    }

    @Operation(
            summary = "Поиск записи по полю Assembly",
            description = "Возвращает первую запись из JSON файла, у которой поле Assembly совпадает с переданным значением."
    )
    @GetMapping("/by-assembly")
    public ResponseEntity<?> getAssembly(@Parameter(
            description = "Название геномной сборки (например GRCh38)",
            example = "GRCh38"
    ) @RequestParam  String assembl) throws IOException {
        GeneInfoJson res = geneService.getByAssemblyAtJson(assembl);
        if (res == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Gene not found\"}");
        }
        return ResponseEntity.ok(res);
    }

}

