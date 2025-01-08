package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="method")
public class MethodEntity extends BrAPIPrimaryEntity implements OntologyReferenceHolder{
	@Column
	private String name;
	@Column
	private String methodClass;
	@Column
	private String methodPUI;
	@Column
	private String description;
	@Column
	private String formula;
	@Column
	private String reference;
	@OneToMany(mappedBy="method")
	private List<VariableBaseEntity> variables;
	@OneToOne(fetch = FetchType.LAZY)
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
