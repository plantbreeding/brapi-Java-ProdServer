package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "list_item")
public class ListItemEntity extends BrAPIBaseEntity {
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ListEntity list;
	@Column
	private String item;
	@Column
	private Integer position;
	
	public ListEntity getList() {
		return list;
	}
	public void setList(ListEntity list) {
		this.list = list;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
}
