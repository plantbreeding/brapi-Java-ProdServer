package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import io.swagger.model.geno.VendorOrderStatusResponseResult.StatusEnum;
import io.swagger.model.geno.VendorPlateSubmissionRequest.SampleTypeEnum;

@Entity
@Table(name="vendor_order")
public class VendorOrderEntity extends BrAPIPrimaryEntity{
	@Column
    private String clientPlateDbId;
	@Column
    private String clientPlateBarcode;
	@Column
    private SampleTypeEnum sampleType;
	@Column
    private StatusEnum status;
	@Column
    private Date statusTimeStamp;
	@OneToOne(cascade = CascadeType.ALL, mappedBy= "order", fetch = FetchType.LAZY)
    private VendorPlateSubmissionEntity plateSubmission;
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<VendorFileEntity> files;
	@ElementCollection
	private Map<String, String> requiredServiceInfo;
	@ElementCollection
	private List<String> serviceIds;
	
	
	public SampleTypeEnum getSampleType() {
		return sampleType;
	}
	public void setSampleType(SampleTypeEnum sampleType) {
		this.sampleType = sampleType;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public Map<String, String> getRequiredServiceInfo() {
		return requiredServiceInfo;
	}
	public void setRequiredServiceInfo(Map<String, String> requiredServiceInfo) {
		this.requiredServiceInfo = requiredServiceInfo;
	}
	public List<String> getServiceIds() {
		return serviceIds;
	}
	public void setServiceIds(List<String> serviceIds) {
		this.serviceIds = serviceIds;
	}
	public VendorPlateSubmissionEntity getPlateSubmission() {
		return plateSubmission;
	}
	public void setPlateSubmission(VendorPlateSubmissionEntity plateSubmission) {
		this.plateSubmission = plateSubmission;
	}
	public String getClientPlateDbId() {
		return clientPlateDbId;
	}
	public void setClientPlateDbId(String clientPlateDbId) {
		this.clientPlateDbId = clientPlateDbId;
	}
	public String getClientPlateBarcode() {
		return clientPlateBarcode;
	}
	public void setClientPlateBarcode(String clientPlateBarcode) {
		this.clientPlateBarcode = clientPlateBarcode;
	}
	public Date getStatusTimeStamp() {
		return statusTimeStamp;
	}
	public void setStatusTimeStamp(Date statusTimeStamp) {
		this.statusTimeStamp = statusTimeStamp;
	}
	public List<VendorFileEntity> getFiles() {
		return files;
	}
	public void setFiles(List<VendorFileEntity> files) {
		this.files = files;
	}
	
	
}
