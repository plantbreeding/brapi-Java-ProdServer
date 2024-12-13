package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="vendor_spec_status")
public class VendorSpecStatusEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorSpecPlatformDbId;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String statusName;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String statusDescription;
	public String getVendorSpecPlatformDbId() {
		return vendorSpecPlatformDbId;
	}
	public void setVendorSpecPlatformDbId(String vendorSpecPlatformDbId) {
		this.vendorSpecPlatformDbId = vendorSpecPlatformDbId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
