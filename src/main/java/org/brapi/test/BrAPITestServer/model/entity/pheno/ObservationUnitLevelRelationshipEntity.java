package org.brapi.test.BrAPITestServer.model.entity.pheno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

import io.swagger.model.pheno.ObservationUnitHierarchyLevelEnum;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "observation_unit_level")
public class ObservationUnitLevelRelationshipEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String levelCode;
	@Column
	private ObservationUnitHierarchyLevelEnum levelName;
	@Column
	private Integer levelOrder;
	@ManyToOne
	private ObservationUnitEntity observationUnit;
	@ManyToOne
	private ObservationUnitPositionEntity position;
	
	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}
	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public ObservationUnitHierarchyLevelEnum getLevelName() {
		return levelName;
	}
	public void setLevelName(ObservationUnitHierarchyLevelEnum levelName) {
		this.levelName = levelName;
	}
	public Integer getLevelOrder() {
		return levelOrder;
	}
	public void setLevelOrder(Integer levelOrder) {
		this.levelOrder = levelOrder;
	}
	public ObservationUnitPositionEntity getPosition() {
		return position;
	}
	public void setPosition(ObservationUnitPositionEntity position) {
		this.position = position;
	}
}
