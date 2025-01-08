package org.brapi.test.BrAPITestServer.model.entity.pheno;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

import io.swagger.model.pheno.ObservationUnitHierarchyLevelEnum;

@Entity
@Table(name = "observation_unit_level")
public class ObservationUnitLevelRelationshipEntity extends BrAPIBaseEntity {
	@Column
	private String levelCode;
	@Column
	private ObservationUnitHierarchyLevelEnum levelName;
	@Column
	private Integer levelOrder;
	@ManyToOne(fetch = FetchType.LAZY)
	private ObservationUnitEntity observationUnit;
	@ManyToOne(fetch = FetchType.LAZY)
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
