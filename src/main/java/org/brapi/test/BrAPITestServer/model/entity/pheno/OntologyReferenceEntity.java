package org.brapi.test.BrAPITestServer.model.entity.pheno;

import io.swagger.model.OntologyReferenceTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "ontology_ref")
public class OntologyReferenceEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String URL;
	@Column
	private OntologyReferenceTypeEnum type;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public OntologyReferenceTypeEnum getType() {
		return type;
	}

	public void setType(OntologyReferenceTypeEnum type) {
		this.type = type;
	}

}