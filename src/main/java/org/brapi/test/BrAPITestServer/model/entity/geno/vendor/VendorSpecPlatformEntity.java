package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="vendor_spec_platform")
public class VendorSpecPlatformEntity extends BrAPIBaseEntity{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorSpecDbId;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String platformName;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String platformDescription;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String platformURL;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String contactName;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String contactEmail;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String contactPhone;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String shippingAddress;
	@OneToMany(mappedBy="vendorSpecPlatformDbId")
    private List<VendorSpecDeliverableEntity> deliverables;
	@OneToOne
    private VendorSpecStandardRequirementEntity standardRequirements;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String specificRequirements;
	@OneToMany(mappedBy="vendorSpecPlatformDbId")
    private List<VendorSpecStatusEntity> statuses;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String taxonomyIdSystemName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String taxonomyIdSystemURI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String tissueIdSystemName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String tissueIdSystemURI;
	public String getVendorSpecDbId() {
		return vendorSpecDbId;
	}
	public void setVendorSpecDbId(String vendorSpecDbId) {
		this.vendorSpecDbId = vendorSpecDbId;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPlatformDescription() {
		return platformDescription;
	}
	public void setPlatformDescription(String platformDescription) {
		this.platformDescription = platformDescription;
	}
	public String getPlatformURL() {
		return platformURL;
	}
	public void setPlatformURL(String platformURL) {
		this.platformURL = platformURL;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public List<VendorSpecDeliverableEntity> getDeliverables() {
		return deliverables;
	}
	public void setDeliverables(List<VendorSpecDeliverableEntity> deliverables) {
		this.deliverables = deliverables;
	}
	public VendorSpecStandardRequirementEntity getStandardRequirements() {
		return standardRequirements;
	}
	public void setStandardRequirements(VendorSpecStandardRequirementEntity standardRequirements) {
		this.standardRequirements = standardRequirements;
	}
	public String getSpecificRequirements() {
		return specificRequirements;
	}
	public void setSpecificRequirements(String specificRequirements) {
		this.specificRequirements = specificRequirements;
	}
	public List<VendorSpecStatusEntity> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<VendorSpecStatusEntity> statuses) {
		this.statuses = statuses;
	}
	public String getTaxonomyIdSystemName() {
		return taxonomyIdSystemName;
	}
	public void setTaxonomyIdSystemName(String taxonomyIdSystemName) {
		this.taxonomyIdSystemName = taxonomyIdSystemName;
	}
	public String getTaxonomyIdSystemURI() {
		return taxonomyIdSystemURI;
	}
	public void setTaxonomyIdSystemURI(String taxonomyIdSystemURI) {
		this.taxonomyIdSystemURI = taxonomyIdSystemURI;
	}
	public String getTissueIdSystemName() {
		return tissueIdSystemName;
	}
	public void setTissueIdSystemName(String tissueIdSystemName) {
		this.tissueIdSystemName = tissueIdSystemName;
	}
	public String getTissueIdSystemURI() {
		return tissueIdSystemURI;
	}
	public void setTissueIdSystemURI(String tissueIdSystemURI) {
		this.tissueIdSystemURI = tissueIdSystemURI;
	}
	
}
