package com.taske.taskDelat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class GeneInfoJson {
        @JsonProperty("VariationID")
        private Integer variationID;

        @JsonProperty("GeneSymbol")
        private String geneSymbol;

        @JsonProperty("ClinicalSignificance")
        private String clinicalSignificance;

        @JsonProperty("PhenotypeIDS")
        private String phenotypeIDS;

        @JsonProperty("PhenotypeList")
        private String phenotypeList;

        @JsonProperty("Assembly")
        private String assembly;

        @JsonProperty("ChromosomeAccession")
        private String chromosomeAccession;

        @JsonProperty("SyntheticConclusion")
        private String syntheticConclusion;

        @JsonProperty("SyntheticID")
        private Integer syntheticID;

    public GeneInfoJson() {
    }

    public GeneInfoJson(Integer variationID, String geneSymbol, String clinicalSignificance, String phenotypeIDS, String phenotypeList, String assembly, String chromosomeAccession, String syntheticConclusion, Integer syntheticID) {
        this.variationID = variationID;
        this.geneSymbol = geneSymbol;
        this.clinicalSignificance = clinicalSignificance;
        this.phenotypeIDS = phenotypeIDS;
        this.phenotypeList = phenotypeList;
        this.assembly = assembly;
        this.chromosomeAccession = chromosomeAccession;
        this.syntheticConclusion = syntheticConclusion;
        this.syntheticID = syntheticID;
    }

    public Integer getVariationID() {
        return variationID;
    }

    public void setVariationID(Integer variationID) {
        this.variationID = variationID;
    }

    public String getGeneSymbol() {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol) {
        this.geneSymbol = geneSymbol;
    }

    public String getClinicalSignificance() {
        return clinicalSignificance;
    }

    public void setClinicalSignificance(String clinicalSignificance) {
        this.clinicalSignificance = clinicalSignificance;
    }

    public String getPhenotypeIDS() {
        return phenotypeIDS;
    }

    public void setPhenotypeIDS(String phenotypeIDS) {
        this.phenotypeIDS = phenotypeIDS;
    }

    public String getPhenotypeList() {
        return phenotypeList;
    }

    public void setPhenotypeList(String phenotypeList) {
        this.phenotypeList = phenotypeList;
    }

    public String getAssembly() {
        return assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }

    public String getChromosomeAccession() {
        return chromosomeAccession;
    }

    public void setChromosomeAccession(String chromosomeAccession) {
        this.chromosomeAccession = chromosomeAccession;
    }

    public String getSyntheticConclusion() {
        return syntheticConclusion;
    }

    public void setSyntheticConclusion(String syntheticConclusion) {
        this.syntheticConclusion = syntheticConclusion;
    }

    public Integer getSyntheticID() {
        return syntheticID;
    }

    public void setSyntheticID(Integer syntheticID) {
        this.syntheticID = syntheticID;
    }
}


