package org.brapi.test.BrAPITestServer.model.entity.germ;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="germplasm_origin")
public class GermplasmOriginEntity extends BrAPIBaseEntity{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String coordinateUncertainty;
	@OneToOne(cascade = CascadeType.ALL)
	private GeoJSONEntity coordinates;
	@ManyToOne
	private GermplasmEntity germplasm;
	
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	public String getCoordinateUncertainty() {
		return coordinateUncertainty;
	}
	public void setCoordinateUncertainty(String coordinateUncertainty) {
		this.coordinateUncertainty = coordinateUncertainty;
	}
	public GeoJSONEntity getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(GeoJSONEntity coordinates) {
		this.coordinates = coordinates;
	}

}
