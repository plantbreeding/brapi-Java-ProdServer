package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="cross_pollination_event")
public class CrossPollinationEventEntity extends BrAPIBaseEntity {
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String pollinationNumber = null;
	@Column
	private Boolean pollinationSuccessful = null;
	@Column
	private Date pollinationTimeStamp = null;
	@ManyToOne
	private CrossEntity cross;

	public CrossEntity getCross() {
		return cross;
	}

	public void setCross(CrossEntity cross) {
		this.cross = cross;
	}

	public String getPollinationNumber() {
		return pollinationNumber;
	}

	public void setPollinationNumber(String pollinationNumber) {
		this.pollinationNumber = pollinationNumber;
	}

	public Boolean getPollinationSuccessful() {
		return pollinationSuccessful;
	}

	public void setPollinationSuccessful(Boolean pollinationSuccessful) {
		this.pollinationSuccessful = pollinationSuccessful;
	}

	public Date getPollinationTimeStamp() {
		return pollinationTimeStamp;
	}

	public void setPollinationTimeStamp(Date pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
	}
	
}
