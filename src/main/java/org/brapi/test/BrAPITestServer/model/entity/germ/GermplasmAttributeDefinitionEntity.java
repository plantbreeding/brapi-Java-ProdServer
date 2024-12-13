package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.pheno.VariableBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "germplasm_attribute_definition")
public class GermplasmAttributeDefinitionEntity extends VariableBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String attributeCategory;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String code;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String uri;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String name;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String pui;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String datatype;
	@OneToMany(mappedBy = "attribute")
	private List<GermplasmAttributeValueEntity> values;

	
	public String getPUI() {
		return pui;
	}

	public void setPUI(String pui) {
		this.pui = pui;
	}

	public String getAttributeCategory() {
		return attributeCategory;
	}

	public void setAttributeCategory(String attributeCategory) {
		this.attributeCategory = attributeCategory;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public List<GermplasmAttributeValueEntity> getValues() {
		return values;
	}

	public void setValues(List<GermplasmAttributeValueEntity> values) {
		this.values = values;
	}

}
