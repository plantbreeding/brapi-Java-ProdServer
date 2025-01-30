package org.brapi.test.BrAPITestServer.model.entity;

import io.swagger.model.ExternalReferences;
import io.swagger.model.ExternalReferencesInner;

import jakarta.persistence.*;
import org.brapi.test.BrAPITestServer.converter.JsonbConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@MappedSuperclass
public class BrAPIPrimaryEntity extends BrAPIBaseEntity {

	@Convert(converter= JsonbConverter.class)
	@Column(columnDefinition="jsonb")
	private Map<String, Object> additionalInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = {@JoinColumn(referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(referencedColumnName = "id")})
    private List<ExternalReferenceEntity> externalReferences;

    @Column
    private UUID authUserId;

    public UUID getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(UUID authUserId) {
        this.authUserId = authUserId;
    }

	public Map<String, Object> getAdditionalInfo() {
		return this.additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> info) {
		this.additionalInfo = info;
	}

    public List<ExternalReferenceEntity> getExternalReferences() {
        return externalReferences;
    }

    public void setExternalReferences(List<ExternalReferenceEntity> externalReferences) {
        this.externalReferences = externalReferences;
    }

    public ExternalReferences getExternalReferencesMap() {
        ExternalReferences exRefs = new ExternalReferences();
        if (getExternalReferences() != null) {
            for (ExternalReferenceEntity entity : getExternalReferences()) {
                ExternalReferencesInner exRef = new ExternalReferencesInner();
                exRef.setReferenceID(entity.getExternalReferenceId().toString());
                exRef.setReferenceSource(entity.getExternalReferenceSource());
                exRefs.add(exRef);
            }
        }
        return exRefs;
    }

    public void setExternalReferences(ExternalReferences exRefs) {
        if (exRefs != null) {
            setExternalReferences(new ArrayList<>());
            for (ExternalReferencesInner exRef : exRefs) {
                ExternalReferenceEntity entity = new ExternalReferenceEntity();
                entity.setExternalReferenceId(UUID.fromString(exRef.getReferenceID()));
                entity.setExternalReferenceSource(exRef.getReferenceSource());
                getExternalReferences().add(entity);
            }
        }
    }

}
