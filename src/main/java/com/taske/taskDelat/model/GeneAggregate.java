package com.taske.taskDelat.model;

import java.util.List;

public class GeneAggregate {
    private GeneInfo gene;
    private List<DiseaseHit> diseases;

    public GeneAggregate() {}

    public GeneAggregate(GeneInfo gene, List<DiseaseHit> diseases) {
        this.gene = gene;
        this.diseases = diseases;
    }

    public GeneInfo getGene() { return gene; }
    public void setGene(GeneInfo gene) { this.gene = gene; }

    public List<DiseaseHit> getDiseases() { return diseases; }
    public void setDiseases(List<DiseaseHit> diseases) { this.diseases = diseases; }
}