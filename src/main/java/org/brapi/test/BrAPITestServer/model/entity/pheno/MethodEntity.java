package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="method")
public class MethodEntity extends BrAPIPrimaryEntity implements OntologyReferenceHolder{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String name;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String methodClass;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String methodPUI;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String formula;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String reference;
	@OneToMany(mappedBy="method")
	private List<VariableBaseEntity> variables;
	@OneToOne
	private OntologyEntity ontology;
	@JoinTable
	@OneToMany(cascade = CascadeType.ALL)
	private List<OntologyReferenceEntity> ontologyReference;

	public String getMethodPUI() {
		return methodPUI;
	}
	public void setMethodPUI(String methodPUI) {
		this.methodPUI = methodPUI;
	}
	public OntologyEntity getOntology() {
		return ontology;
	}
	public void setOntology(OntologyEntity ontology) {
		this.ontology = ontology;
	}
	public List<OntologyReferenceEntity> getOntologyReference() {
		return ontologyReference;
	}
	public void setOntologyReference(List<OntologyReferenceEntity> ontologyReference) {
		this.ontologyReference = ontologyReference;
	}
	public List<VariableBaseEntity> getVariables() {
		return variables;
	}
	public void setVariables(List<VariableBaseEntity> variables) {
		this.variables = variables;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMethodClass() {
		return methodClass;
	}
	public void setMethodClass(String methodClass) {
		this.methodClass = methodClass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
}
