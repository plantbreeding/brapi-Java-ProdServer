package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "event_param")
public class EventParameterEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String key;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String rdfValue;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String value;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String code;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String name;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String units;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String valueDescription;
	@ElementCollection
	private List<String> valuesByDate;
	@ManyToOne
	private EventEntity event;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getValueDescription() {
		return valueDescription;
	}

	public void setValueDescription(String valueDescription) {
		this.valueDescription = valueDescription;
	}

	public List<String> getValuesByDate() {
		return valuesByDate;
	}

	public void setValuesByDate(List<String> valuesByDate) {
		this.valuesByDate = valuesByDate;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRdfValue() {
		return rdfValue;
	}

	public void setRdfValue(String rdfValue) {
		this.rdfValue = rdfValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}
}
