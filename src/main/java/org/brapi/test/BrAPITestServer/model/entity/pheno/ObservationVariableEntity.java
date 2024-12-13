package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="observation_variable")
public class ObservationVariableEntity extends VariableBaseEntity{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String name;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String pui;
	@OneToMany(mappedBy="observationVariable")
	private List<ObservationEntity> observations;
	
	public String getPui() {
		return pui;
	}
	public void setPui(String pui) {
		this.pui = pui;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ObservationEntity> getObservations() {
		return observations;
	}
	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}
	
}
