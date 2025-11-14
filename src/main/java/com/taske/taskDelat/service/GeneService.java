package com.taske.taskDelat.service;

import com.taske.taskDelat.model.DiseaseHit;
import com.taske.taskDelat.model.GeneAggregate;
import com.taske.taskDelat.model.GeneInfo;
import com.taske.taskDelat.repo.GeneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class GeneService {

    // private final WebClient webClient = WebClient.create("https://mygene.info/v3");
    private final GeneRepository geneRepository;
    private static final Logger log = LoggerFactory.getLogger(GeneService.class);


    public GeneService(GeneRepository geneRepository) {
        this.geneRepository = geneRepository;
    }

    @Cacheable(value = "genes", key = "#geneSymbol")
    public GeneInfo findBySymbol(String geneSymbol) {
        if (geneSymbol == null || geneSymbol.isBlank()) {
            log.warn("Enter a gene");
            return (GeneInfo) Collections.EMPTY_LIST;
        }
        List<Object[]> repo = geneRepository.findIdAndNameAndSymbolByGeneSymbol(geneSymbol);
        if (repo.isEmpty()) {
            log.info("no Gene found");
            return (GeneInfo) Collections.EMPTY_LIST;
        }
        Object[] row = repo.get(0);
        Long variationID = (Long) row[0];
        String GeneSymbol = (String) row[1];
        String conclusion = (String) row[2];

        return new GeneInfo(variationID, GeneSymbol, conclusion);
    }

    public List<GeneInfo> getBySignificance(String significance) {
        List<Object[]> repository = geneRepository.findByClinicalSignificance(significance);
        if (repository.isEmpty()) {
            log.info("No genes found with significance: {}", significance);
            return Collections.EMPTY_LIST;
        }
        List<GeneInfo> results = new ArrayList<>();
        for (Object[] row : repository) {
            Long variationID = (Long) row[0];
            String GeneSymbol = (String) row[1];
            String conclusion = (String) row[2];
            String Significance = (String) row[3];
            results.add(new GeneInfo(variationID, GeneSymbol, conclusion,Significance));

        }
        return results;
    }


    public List<GeneInfo> getByAssembly(String assembly){
        List<Object[] > repo = geneRepository.findByAssembly(assembly);
        if(repo.isEmpty()){
            log.info("No genes found for assembly: {}", assembly);
            return Collections.EMPTY_LIST;
        }
        List<GeneInfo> res =  new ArrayList<>();
        for(Object[] row : repo){
            String GeneSymbol = (String) row[0];
            String conclusion = (String) row[1];
            res.add(new GeneInfo(GeneSymbol, conclusion));
        }
        return res;
    }

    /* public GeneInfo findBySymbol(String geneSymbol){
        if(geneSymbol == null || geneSymbol.isBlank()){
            System.out.println("Enter a symbol");
            return null;

        }
        List<Object[]> repo  = geneRepository.findIdAndNameAndSymbolByGeneSymbol(geneSymbol);

        if(repo.isEmpty()){
            System.out.println("Repository is empty");
            return null;

        }
        Object [] row = repo.get(0);
        Long  variationID = (Long) row[0];
        String  phenotyp = (String) row[1];
        String  geneS = (String) row[2];
        String  conclusion = (String) row[3];

        return new GeneInfo(variationID,phenotyp,geneSymbol,conclusion);

     }*/
    /*public GeneAggregate getGeneData(String symbol) {
        GeneInfo gene = fetchGeneInfo(symbol);
        List<DiseaseHit> diseases = new ArrayList<>();


        diseases.add(new DiseaseHit("omim", "OMIM API not connected", "https://omim.org/"));

        return new GeneAggregate(gene, diseases);
    }*/

    /*public GeneInfo getGeneBySymbol(String symbol){
        return  geneRepository.findBySymbol(symbol)
                .orElseGet( () ->{
                    GeneInfo geneInfo = fetchGeneInfo(symbol);

                    return geneRepository.save(geneInfo);
                });
    }

    private GeneInfo fetchGeneInfo(String symbol) {
        try {
            // Делаем запрос к внешнему API (например, MyGene.info)
            Map<String, Object> apiResponse = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/query")
                            .queryParam("q", "symbol:" + symbol)
                            .queryParam("species", "human")
                            .queryParam("size", "1")
                            .queryParam("fields", "symbol,name,entrezgene,summary,OMIM")
                            .build())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            // Проверка на пустой ответ
            if (apiResponse == null || !apiResponse.containsKey("hits")) {
                return new GeneInfo(symbol, "Not found", null, null);
            }

            // Извлекаем список найденных записей
            List<Map<String, Object>> hits = (List<Map<String, Object>>) apiResponse.get("hits");
            if (hits == null || hits.isEmpty()) {
                return new GeneInfo(symbol, "Not found", null, null);
            }

            // Берем первый найденный ген
            Map<String, Object> hit = hits.get(0);

            // Создаём объект GeneInfo
            GeneInfo gene = new GeneInfo();
            gene.setSymbol((String) hit.getOrDefault("symbol", symbol));
            gene.setName((String) hit.getOrDefault("name", "Unknown"));
            gene.setSummary((String) hit.getOrDefault("summary", ""));
            gene.setOmim(hit.containsKey("OMIM") ? hit.get("OMIM").toString() : null);

            return gene;

        } catch (Exception e) {
            e.printStackTrace();
            return new GeneInfo(symbol, "Error fetching data", null, null);
        }
    }*/

}