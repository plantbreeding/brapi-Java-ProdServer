package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="vendor_spec_deliverable")
public class VendorSpecDeliverableEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorSpecPlatformDbId;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String name;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String format;
	public String getVendorSpecPlatformDbId() {
		return vendorSpecPlatformDbId;
	}
	public void setVendorSpecPlatformDbId(String vendorSpecPlatformDbId) {
		this.vendorSpecPlatformDbId = vendorSpecPlatformDbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
}
