package com.taske.taskDelat.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "genes_infos")
public class NewGeneInfo {

    @Id
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "referral_diagnosis")
    private String referral_diagnosis;

    @Column(name = "phenotype")
    private String phenotype;
    @Column(name = "conclusion")
    private String conclusion;
    @Column(name = "notes")
    private String notes;
    @Column(name = "synthetic_conclusion")
    private String synthetic_conclusion;

    public NewGeneInfo() {
    }

    public NewGeneInfo(String referral_diagnosis, String phenotype, String conclusion, String notes, String synthetic_conclusion) {
        this.referral_diagnosis = referral_diagnosis;
        this.phenotype = phenotype;
        this.conclusion = conclusion;
        this.notes = notes;
        this.synthetic_conclusion = synthetic_conclusion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public String getReferral_diagnosis() {
        return referral_diagnosis;
    }

    public void setReferral_diagnosis(String referral_diagnosis) {
        this.referral_diagnosis = referral_diagnosis;
    }

    public String getPhenotype() {
        return phenotype;
    }

    public void setPhenotype(String phenotype) {
        this.phenotype = phenotype;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSynthetic_conclusion() {
        return synthetic_conclusion;
    }

    public void setSynthetic_conclusion(String synthetic_conclusion) {
        this.synthetic_conclusion = synthetic_conclusion;
    }
}
