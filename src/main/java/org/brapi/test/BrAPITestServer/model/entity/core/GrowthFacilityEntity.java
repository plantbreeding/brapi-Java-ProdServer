package org.brapi.test.BrAPITestServer.model.entity.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "study_growth_facility")
public class GrowthFacilityEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String PUI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@OneToOne
	private StudyEntity study;

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
	}

	public String getPUI() {
		return PUI;
	}

	public void setPUI(String pUI) {
		PUI = pUI;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
