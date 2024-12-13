package org.brapi.test.BrAPITestServer.model.entity.geno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="reference_set")
public class ReferenceSetEntity extends BrAPIPrimaryEntity  {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String assemblyPUI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	private Boolean isDerived;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String md5checksum;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String referenceSetName;
	@ManyToOne
	private GermplasmEntity sourceGermplasm;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String sourceURI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String speciesOntologyTerm;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String speciesOntologyTermURI;
	
	public String getAssemblyPUI() {
		return assemblyPUI;
	}
	public void setAssemblyPUI(String assemblyPUI) {
		this.assemblyPUI = assemblyPUI;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsDerived() {
		return isDerived;
	}
	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}
	public String getMd5checksum() {
		return md5checksum;
	}
	public void setMd5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
	}
	public String getReferenceSetName() {
		return referenceSetName;
	}
	public void setReferenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
	}
	public GermplasmEntity getSourceGermplasm() {
		return sourceGermplasm;
	}
	public void setSourceGermplasm(GermplasmEntity sourceGermplasm) {
		this.sourceGermplasm = sourceGermplasm;
	}
	public String getSourceURI() {
		return sourceURI;
	}
	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}
	public String getSpeciesOntologyTerm() {
		return speciesOntologyTerm;
	}
	public void setSpeciesOntologyTerm(String speciesOntologyTerm) {
		this.speciesOntologyTerm = speciesOntologyTerm;
	}
	public String getSpeciesOntologyTermURI() {
		return speciesOntologyTermURI;
	}
	public void setSpeciesOntologyTermURI(String speciesOntologyTermURI) {
		this.speciesOntologyTermURI = speciesOntologyTermURI;
	}
}
