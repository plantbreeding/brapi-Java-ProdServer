package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "trial_publication")
public class PublicationEntity extends BrAPIBaseEntity {
	@Column
	private String publicationPUI;
	@Column 
	private String publicationReference;
	@ManyToOne(fetch = FetchType.LAZY)
	private TrialEntity trial;
	
	public String getPublicationPUI() {
		return publicationPUI;
	}
	public void setPublicationPUI(String publicationPUI) {
		this.publicationPUI = publicationPUI;
	}
	public String getPublicationReference() {
		return publicationReference;
	}
	public void setPublicationReference(String publicationReference) {
		this.publicationReference = publicationReference;
	}
	public TrialEntity getTrial() {
		return trial;
	}
	public void setTrial(TrialEntity trial) {
		this.trial = trial;
	}
	
}
