package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.PlateEntity;

import io.swagger.model.geno.VendorPlateSubmissionRequest.SampleTypeEnum;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="plate_submission")
public class VendorPlateSubmissionEntity extends BrAPIPrimaryEntity{
	
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String clientId;
	@Column
	private Integer numberOfSamples;
	@Column
	private SampleTypeEnum sampleType;
	@OneToMany(mappedBy="submission", cascade = CascadeType.ALL)
    private List<PlateEntity> plates;
	@OneToOne(cascade = CascadeType.ALL)
	private VendorOrderEntity order;
	
	
	public VendorOrderEntity getOrder() {
		return order;
	}
	public void setOrder(VendorOrderEntity order) {
		this.order = order;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Integer getNumberOfSamples() {
		return numberOfSamples;
	}
	public void setNumberOfSamples(Integer numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}
	public SampleTypeEnum getSampleType() {
		return sampleType;
	}
	public void setSampleType(SampleTypeEnum sampleType) {
		this.sampleType = sampleType;
	}
	public List<PlateEntity> getPlates() {
		return plates;
	}
	public void setPlates(List<PlateEntity> plates) {
		this.plates = plates;
	}
	
}
