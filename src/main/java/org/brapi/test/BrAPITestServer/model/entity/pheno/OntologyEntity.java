package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="ontology")
public class OntologyEntity extends BrAPIPrimaryEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String ontologyName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String authors;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String version;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String copyright;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String licence;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String documentationURL;
	@OneToMany(mappedBy="ontology")
	private List<VariableBaseEntity> variables;
	@ElementCollection
	private List<String> documentationLinks;

	public List<String> getDocumentationLinks() {
		return documentationLinks;
	}
	public void setDocumentationLinks(List<String> documentationLinks) {
		this.documentationLinks = documentationLinks;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public List<VariableBaseEntity> getVariables() {
		return variables;
	}
	public void setVariables(List<VariableBaseEntity> variables) {
		this.variables = variables;
	}
	public String getOntologyName() {
		return ontologyName;
	}
	public void setOntologyName(String ontologyName) {
		this.ontologyName = ontologyName;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
}
