package org.brapi.test.BrAPITestServer.model.entity.pheno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "observation_unit_treatment")
public class TreatmentEntity extends BrAPIBaseEntity {
    @ManyToOne
    private ObservationUnitEntity observationUnit;
    @Column
    private String factor;
    @Column
    private String modality;

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public ObservationUnitEntity getObservationUnit() {
        return observationUnit;
    }

    public void setObservationUnit(ObservationUnitEntity observationUnit) {
        this.observationUnit = observationUnit;
    }
}
