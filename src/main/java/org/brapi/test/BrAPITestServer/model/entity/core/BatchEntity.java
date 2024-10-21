package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import io.swagger.model.core.BatchTypes;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;

@Entity
@Table(name = "batch")
public class BatchEntity extends BrAPIPrimaryEntity {
	@Column
	private Date dateCreated;
	@Column
	private Date dateModified;
	@Column
	private String description;
	@Column
	private String batchName;
	@Column
	private String batchOwnerName;
	@Column
	private String batchSource;
	@Column
	private BatchTypes batchType;

	@ManyToOne(fetch = FetchType.LAZY)
	private PersonEntity batchOwnerPerson;
	@OneToMany(mappedBy="batch", cascade = CascadeType.ALL)
	private List<BatchItemEntity> data;

	public PersonEntity getBatchOwnerPerson() {
		return batchOwnerPerson;
	}

	public void setBatchOwnerPerson(PersonEntity batchOwnerPerson) {
		this.batchOwnerPerson = batchOwnerPerson;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchOwnerName() {
		return batchOwnerName;
	}

	public void setBatchOwnerName(String batchOwnerName) {
		this.batchOwnerName = batchOwnerName;
	}

	public String getBatchSource() {
		return batchSource;
	}

	public void setBatchSource(String batchSource) {
		this.batchSource = batchSource;
	}

	public BatchTypes getBatchType() {
		return batchType;
	}

	public void setBatchType(BatchTypes batchType) {
		this.batchType = batchType;
	}

	public List<BatchItemEntity> getData() {
		return data;
	}

	public void setData(List<BatchItemEntity> data) {
		this.data = data;
	}
	
	
}