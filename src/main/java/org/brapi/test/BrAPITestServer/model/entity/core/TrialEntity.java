package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "trial")
public class TrialEntity extends BrAPIPrimaryEntity {
	@Column
	private Boolean active;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trial_contact", joinColumns = {
			@JoinColumn(name = "trial_db_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "person_db_id", referencedColumnName = "id") })
	private List<PersonEntity> contacts;
	@OneToMany(mappedBy = "trial")
	private List<DatasetAuthorshipEntity> datasetAuthorships;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String documentationURL;
	@Column
	private Date endDate;
	@OneToMany(mappedBy = "trial")
	private List<PublicationEntity> publications;
	@Column
	private Date startDate;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String trialDescription;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String trialName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String trialPUI;

	@ManyToOne
	private CropEntity crop;
	@ManyToOne
	private ProgramEntity program;
	
	@OneToMany(mappedBy = "trial")
	private List<StudyEntity> studies;
	@OneToMany(mappedBy="trial")
	private List<ObservationUnitEntity> observationUnits;
	@OneToMany(mappedBy="trial")
	private List<ObservationEntity> observations;
	
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}
	public List<ObservationUnitEntity> getObservationUnits() {
		return observationUnits;
	}
	public void setObservationUnits(List<ObservationUnitEntity> observationUnits) {
		this.observationUnits = observationUnits;
	}
	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<PersonEntity> getContacts() {
		return contacts;
	}
	public void setContacts(List<PersonEntity> contacts) {
		this.contacts = contacts;
	}
	public List<DatasetAuthorshipEntity> getDatasetAuthorships() {
		return datasetAuthorships;
	}
	public void setDatasetAuthorships(List<DatasetAuthorshipEntity> datasetAuthorships) {
		this.datasetAuthorships = datasetAuthorships;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
		if (program.getCrop() != null)
			setCrop(program.getCrop());
	}
	public List<PublicationEntity> getPublications() {
		return publications;
	}
	public void setPublications(List<PublicationEntity> publications) {
		this.publications = publications;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getTrialDescription() {
		return trialDescription;
	}
	public void setTrialDescription(String trialDescription) {
		this.trialDescription = trialDescription;
	}
	public String getTrialName() {
		return trialName;
	}
	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}
	public String getTrialPUI() {
		return trialPUI;
	}
	public void setTrialPUI(String trialPUI) {
		this.trialPUI = trialPUI;
	}
	public List<StudyEntity> getStudies() {
		return studies;
	}
	public void setStudies(List<StudyEntity> studies) {
		this.studies = studies;
	}

}
