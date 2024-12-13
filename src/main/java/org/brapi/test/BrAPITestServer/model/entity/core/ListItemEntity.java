package org.brapi.test.BrAPITestServer.model.entity.core;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "list_item")
public class ListItemEntity extends BrAPIBaseEntity {
	@ManyToOne(cascade = CascadeType.ALL)
	private ListEntity list;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String item;
	
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
	
	
}
