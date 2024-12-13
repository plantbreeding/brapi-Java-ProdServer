package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="vendor_spec")
public class VendorSpecEntity extends BrAPIPrimaryEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorDescription;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorURL;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String contactName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorEmail;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorPhone;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorAddress;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorCity;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String vendorCountry;
	@OneToMany(mappedBy="vendorSpecDbId")
	private List<VendorSpecPlatformEntity> platforms;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorDescription() {
		return vendorDescription;
	}
	public void setVendorDescription(String vendorDescription) {
		this.vendorDescription = vendorDescription;
	}
	public String getVendorURL() {
		return vendorURL;
	}
	public void setVendorURL(String vendorURL) {
		this.vendorURL = vendorURL;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorCountry() {
		return vendorCountry;
	}
	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}
	public List<VendorSpecPlatformEntity> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<VendorSpecPlatformEntity> platforms) {
		this.platforms = platforms;
	}

}
