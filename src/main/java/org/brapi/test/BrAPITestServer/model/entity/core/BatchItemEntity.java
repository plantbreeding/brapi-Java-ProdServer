package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "batch_item")
public class BatchItemEntity extends BrAPIBaseEntity {
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BatchEntity batch;
	@Column
	private String item;
	
	public BatchEntity getBatch() {
		return batch;
	}
	public void setBatch(BatchEntity batch) {
		this.batch = batch;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}