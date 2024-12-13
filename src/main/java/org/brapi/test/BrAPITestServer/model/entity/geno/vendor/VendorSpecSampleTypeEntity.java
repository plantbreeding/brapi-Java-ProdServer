package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name="vendor_spec_sample_type")
public class VendorSpecSampleTypeEntity extends BrAPIBaseEntity {
	@Column
	private String vendorSpecStandardRequirementDbId;
	@Column
	private String sampleType;
	public String getVendorSpecStandardRequirementDbId() {
		return vendorSpecStandardRequirementDbId;
	}
	public void setVendorSpecStandardRequirementDbId(String vendorSpecStandardRequirementDbId) {
		this.vendorSpecStandardRequirementDbId = vendorSpecStandardRequirementDbId;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
}
