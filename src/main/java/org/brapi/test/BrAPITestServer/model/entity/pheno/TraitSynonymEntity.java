package org.brapi.test.BrAPITestServer.model.entity.pheno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "trait_synonym")
public class TraitSynonymEntity extends BrAPIBaseEntity {
    @ManyToOne
    private TraitEntity trait;
    @Column
    private String synonym;

    public TraitEntity getTrait() {
        return trait;
    }

    public void setTrait(TraitEntity trait) {
        this.trait = trait;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

}
