package org.brapi.test.BrAPITestServer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="external_reference")
public class ExternalReferenceEntity extends BrAPIBaseEntity{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String externalReferenceId;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String externalReferenceSource;
	public String getExternalReferenceId() {
		return externalReferenceId;
	}
	public void setExternalReferenceId(String externalReferenceId) {
		this.externalReferenceId = externalReferenceId;
	}
	public String getExternalReferenceSource() {
		return externalReferenceSource;
	}
	public void setExternalReferenceSource(String externalReferenceSource) {
		this.externalReferenceSource = externalReferenceSource;
	}
	
}
