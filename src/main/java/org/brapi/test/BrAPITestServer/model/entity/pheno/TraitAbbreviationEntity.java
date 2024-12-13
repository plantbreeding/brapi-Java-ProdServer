package org.brapi.test.BrAPITestServer.model.entity.pheno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "trait_abbreviation")
public class TraitAbbreviationEntity extends BrAPIBaseEntity {
    @ManyToOne
    private TraitEntity trait;
    @Column
    private String abbreviation;

    public TraitEntity getTrait() {
        return trait;
    }

    public void setTrait(TraitEntity trait) {
        this.trait = trait;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }


}
