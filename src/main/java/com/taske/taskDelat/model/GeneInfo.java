package com.taske.taskDelat.model;


import jakarta.persistence.*;

@Entity
@Table(name="gene_info")
public class GeneInfo {

    @Id
    @Column(name = "\"VariationID\"")
    private Long variationId;

    @Column(name = "\"GeneSymbol\"")
    private String geneSymbol;

    @Column(name = "\"ClinicalSignificance\"")
    private String clinicalSignificance;

    @Column(name = "\"PhenotypeIDS\"")
    private String phenotypeIds;

    @Column(name = "\"PhenotypeList\"")
    private String phenotypeList;

    @Column(name = "\"Origin\"")
    private String origin;

    @Column(name = "\"ReviewStatus\"")
    private String reviewStatus;

    @Column(name = "\"Assembly\"")
    private String assembly;

    @Column(name = "\"ReferenceAllele\"")
    private String referenceAllele;

    @Column(name = "\"AlternateAllele\"")
    private String alternateAllele;

    @Column(name = "\"ChromosomeAccession\"")
    private String chromosomeAccession;

    @Column(name = "\"Start\"")
    private Long start;

    @Column(name = "\"Stop\"")
    private Long stop;

    @Column(name = "\"SyntheticConclusion\"")
    private String syntheticConclusion;

    @Column(name = "\"SyntheticID\"")
    private String syntheticId;

    public GeneInfo() {}

    public GeneInfo(String geneSymbol, String clinicalSignificance, String phenotypeIds, String phenotypeList, String origin, String reviewStatus, String assembly, String referenceAllele, String alternateAllele, String chromosomeAccession, String syntheticConclusion) {
        this.geneSymbol = geneSymbol;
        this.clinicalSignificance = clinicalSignificance;
        this.phenotypeIds = phenotypeIds;
        this.phenotypeList = phenotypeList;
        this.origin = origin;
        this.reviewStatus = reviewStatus;
        this.assembly = assembly;
        this.referenceAllele = referenceAllele;
        this.alternateAllele = alternateAllele;
        this.chromosomeAccession = chromosomeAccession;
        this.syntheticConclusion = syntheticConclusion;
    }

    public GeneInfo(Long variationId, String phenotypeIds,String geneSymbol,String syntheticConclusion){
        this.variationId = variationId;
        this.phenotypeIds = phenotypeIds;
        this.geneSymbol = geneSymbol;
        this.syntheticConclusion = syntheticConclusion;
    }
    public GeneInfo(Long variationId, String geneSymbol, String syntheticConclusion) {
        this.variationId = variationId;
        this.geneSymbol = geneSymbol;
        this.syntheticConclusion = syntheticConclusion;
    }
    public GeneInfo( String geneSymbol, String syntheticConclusion) {
        this.geneSymbol = geneSymbol;
        this.syntheticConclusion = syntheticConclusion;
    }

    public Long getVariationId() {
        return variationId;
    }

    public void setVariationId(Long variationId) {
        this.variationId = variationId;
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

    public String getPhenotypeIds() {
        return phenotypeIds;
    }

    public void setPhenotypeIds(String phenotypeIds) {
        this.phenotypeIds = phenotypeIds;
    }

    public String getPhenotypeList() {
        return phenotypeList;
    }

    public void setPhenotypeList(String phenotypeList) {
        this.phenotypeList = phenotypeList;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getAssembly() {
        return assembly;
    }

    public void setAssembly(String assembly) {
        this.assembly = assembly;
    }

    public String getReferenceAllele() {
        return referenceAllele;
    }

    public void setReferenceAllele(String referenceAllele) {
        this.referenceAllele = referenceAllele;
    }

    public String getAlternateAllele() {
        return alternateAllele;
    }

    public void setAlternateAllele(String alternateAllele) {
        this.alternateAllele = alternateAllele;
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

    // Getters и Setters


}
