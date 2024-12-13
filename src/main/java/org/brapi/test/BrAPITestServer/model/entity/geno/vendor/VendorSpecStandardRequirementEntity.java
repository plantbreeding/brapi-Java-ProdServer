package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="vendor_spec_requirement")
public class VendorSpecStandardRequirementEntity extends BrAPIBaseEntity {
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String minConcentration;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String maxConcentration;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String minVolume;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String maxVolume;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String minSampleNumber;
	@OneToMany(mappedBy="vendorSpecStandardRequirementDbId")
    private List<VendorSpecSampleTypeEntity> sampleTypes;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String sampleTypeDetails;
	@OneToMany(mappedBy="vendorSpecStandardRequirementDbId")
    private List<VendorSpecInputFormatEntity> inputFormats;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String inputFormatDetails;
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String plateOrientation;
	@OneToMany(mappedBy="vendorSpecStandardRequirementDbId")
    private List<VendorSpecWellPositionEntity> blankWellPositions;
	
	public String getMinConcentration() {
		return minConcentration;
	}
	public void setMinConcentration(String minConcentration) {
		this.minConcentration = minConcentration;
	}
	public String getMaxConcentration() {
		return maxConcentration;
	}
	public void setMaxConcentration(String maxConcentration) {
		this.maxConcentration = maxConcentration;
	}
	public String getMinVolume() {
		return minVolume;
	}
	public void setMinVolume(String minVolume) {
		this.minVolume = minVolume;
	}
	public String getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(String maxVolume) {
		this.maxVolume = maxVolume;
	}
	public String getMinSampleNumber() {
		return minSampleNumber;
	}
	public void setMinSampleNumber(String minSampleNumber) {
		this.minSampleNumber = minSampleNumber;
	}
	public List<VendorSpecSampleTypeEntity> getSampleTypes() {
		return sampleTypes;
	}
	public void setSampleTypes(List<VendorSpecSampleTypeEntity> sampleTypes) {
		this.sampleTypes = sampleTypes;
	}
	public String getSampleTypeDetails() {
		return sampleTypeDetails;
	}
	public void setSampleTypeDetails(String sampleTypeDetails) {
		this.sampleTypeDetails = sampleTypeDetails;
	}
	public List<VendorSpecInputFormatEntity> getInputFormats() {
		return inputFormats;
	}
	public void setInputFormats(List<VendorSpecInputFormatEntity> inputFormats) {
		this.inputFormats = inputFormats;
	}
	public String getInputFormatDetails() {
		return inputFormatDetails;
	}
	public void setInputFormatDetails(String inputFormatDetails) {
		this.inputFormatDetails = inputFormatDetails;
	}
	public String getPlateOrientation() {
		return plateOrientation;
	}
	public void setPlateOrientation(String plateOrientation) {
		this.plateOrientation = plateOrientation;
	}
	public List<VendorSpecWellPositionEntity> getBlankWellPositions() {
		return blankWellPositions;
	}
	public void setBlankWellPositions(List<VendorSpecWellPositionEntity> blankWellPositions) {
		this.blankWellPositions = blankWellPositions;
	}
}
