package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="vendor_spec_well_position")
public class VendorSpecWellPositionEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorSpecStandardRequirementDbId;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String position;
	public String getVendorSpecStandardRequirementDbId() {
		return vendorSpecStandardRequirementDbId;
	}
	public void setVendorSpecStandardRequirementDbId(String vendorSpecStandardRequirementDbId) {
		this.vendorSpecStandardRequirementDbId = vendorSpecStandardRequirementDbId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
