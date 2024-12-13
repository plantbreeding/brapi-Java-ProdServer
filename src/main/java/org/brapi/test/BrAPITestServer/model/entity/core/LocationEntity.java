package org.brapi.test.BrAPITestServer.model.entity.core;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="location")
public class LocationEntity extends BrAPIPrimaryEntity{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String abbreviation;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String coordinateDescription;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String coordinateUncertainty;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private GeoJSONEntity coordinates;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String countryCode;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String countryName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String documentationURL;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String environmentType;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String exposure;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String instituteAddress;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String instituteName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String locationName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String locationType;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String siteStatus;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String slope;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String topography;
	@ManyToOne
	private CropEntity crop;
	@ManyToOne
	private ProgramEntity program;
	@ManyToOne
	private LocationEntity parentLocation;

	public LocationEntity getParentLocation() {
		return parentLocation;
	}
	public void setParentLocation(LocationEntity parentLocation) {
		this.parentLocation = parentLocation;
	}
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
	}
	public String getCoordinateDescription() {
		return coordinateDescription;
	}
	public void setCoordinateDescription(String coordinateDescription) {
		this.coordinateDescription = coordinateDescription;
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
	public String getEnvironmentType() {
		return environmentType;
	}
	public void setEnvironmentType(String environmentType) {
		this.environmentType = environmentType;
	}
	public String getExposure() {
		return exposure;
	}
	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getSlope() {
		return slope;
	}
	public void setSlope(String slope) {
		this.slope = slope;
	}
	public String getTopography() {
		return topography;
	}
	public void setTopography(String topography) {
		this.topography = topography;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInstituteAddress() {
		return instituteAddress;
	}
	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}

}
