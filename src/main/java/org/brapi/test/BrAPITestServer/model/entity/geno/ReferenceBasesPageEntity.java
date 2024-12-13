package org.brapi.test.BrAPITestServer.model.entity.geno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "reference_bases")
public class ReferenceBasesPageEntity extends BrAPIPrimaryEntity {
    @ManyToOne
    private ReferenceEntity reference;
    @Column(length = 2048)
    private String bases;
    @Column
    private Integer pageNumber;

    public ReferenceEntity getReference() {
        return reference;
    }

    public void setReference(ReferenceEntity reference) {
        this.reference = reference;
    }

    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

}
