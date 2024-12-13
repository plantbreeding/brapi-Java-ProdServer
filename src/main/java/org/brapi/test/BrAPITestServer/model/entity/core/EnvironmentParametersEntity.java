package org.brapi.test.BrAPITestServer.model.entity.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "study_environment_parameter")
public class EnvironmentParametersEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String parameterName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String parameterPUI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String unit;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String unitPUI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String value;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String valuePUI;
	@ManyToOne
	private StudyEntity study;

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterPUI() {
		return parameterPUI;
	}

	public void setParameterPUI(String parameterPUI) {
		this.parameterPUI = parameterPUI;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitPUI() {
		return unitPUI;
	}

	public void setUnitPUI(String unitPUI) {
		this.unitPUI = unitPUI;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValuePUI() {
		return valuePUI;
	}

	public void setValuePUI(String valuePUI) {
		this.valuePUI = valuePUI;
	}

}
