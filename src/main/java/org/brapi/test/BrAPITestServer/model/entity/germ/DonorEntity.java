package org.brapi.test.BrAPITestServer.model.entity.germ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="germplasm_donor")
public class DonorEntity extends BrAPIPrimaryEntity{
	@ManyToOne
	private GermplasmEntity germplasm;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String donorAccessionNumber;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String donorInstituteCode;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String donorInstituteName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String germplasmPUI;
	
	public String getDonorInstituteName() {
		return donorInstituteName;
	}
	public void setDonorInstituteName(String donorInstituteName) {
		this.donorInstituteName = donorInstituteName;
	}
	public String getDonorAccessionNumber() {
		return donorAccessionNumber;
	}
	public void setDonorAccessionNumber(String donorAccessionNumber) {
		this.donorAccessionNumber = donorAccessionNumber;
	}
	public String getDonorInstituteCode() {
		return donorInstituteCode;
	}
	public void setDonorInstituteCode(String donorInstituteCode) {
		this.donorInstituteCode = donorInstituteCode;
	}
	public String getGermplasmPUI() {
		return germplasmPUI;
	}
	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}
	public GermplasmEntity getGermplasm() {
		return germplasm;
	}
	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}
	
}
