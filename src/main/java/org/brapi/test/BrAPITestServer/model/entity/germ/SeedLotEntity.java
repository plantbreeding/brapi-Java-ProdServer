package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.LocationEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;

@Entity
@Table(name = "seed_lot")
public class SeedLotEntity extends BrAPIPrimaryEntity {
	@Column
	private BigDecimal amount;
	@Column
	private Date createdDate;
	@Column
	private Date lastUpdated;
	@ManyToOne (fetch = FetchType.LAZY)
	private LocationEntity location;
	@ManyToOne(fetch = FetchType.LAZY)
	private ProgramEntity program;
	@Column
	private String description;
	@Column
	private String name;
	@Column
	private String sourceCollection;
	@Column
	private String storageLocation;
	@Column
	private String units;
	@OneToMany(mappedBy = "seedLot")
	private List<SeedLotContentMixtureEntity> contentMixture;
	
	public List<SeedLotContentMixtureEntity> getContentMixture() {
		return contentMixture;
	}
	public void setContentMixture(List<SeedLotContentMixtureEntity> contentMixture) {
		this.contentMixture = contentMixture;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public LocationEntity getLocation() {
		return location;
	}
	public void setLocation(LocationEntity location) {
		this.location = location;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
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
	public String getSourceCollection() {
		return sourceCollection;
	}
	public void setSourceCollection(String sourceCollection) {
		this.sourceCollection = sourceCollection;
	}
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}

}
