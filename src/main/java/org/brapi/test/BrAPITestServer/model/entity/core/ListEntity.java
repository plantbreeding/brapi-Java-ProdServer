package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import io.swagger.model.core.ListTypes;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name = "list")
public class ListEntity extends BrAPIPrimaryEntity {
	@Column
	private Date dateCreated;
	@Column
	private Date dateModified;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String description;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String listName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String listOwnerName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String listSource;
	@Column
	private ListTypes listType;

	@ManyToOne
	private PersonEntity listOwnerPerson;
	@OneToMany(mappedBy="list", cascade = CascadeType.ALL)
	private List<ListItemEntity> data;

	public PersonEntity getListOwnerPerson() {
		return listOwnerPerson;
	}

	public void setListOwnerPerson(PersonEntity listOwnerPerson) {
		this.listOwnerPerson = listOwnerPerson;
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

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListOwnerName() {
		return listOwnerName;
	}

	public void setListOwnerName(String listOwnerName) {
		this.listOwnerName = listOwnerName;
	}

	public String getListSource() {
		return listSource;
	}

	public void setListSource(String listSource) {
		this.listSource = listSource;
	}

	public ListTypes getListType() {
		return listType;
	}

	public void setListType(ListTypes listType) {
		this.listType = listType;
	}

	public List<ListItemEntity> getData() {
		return data;
	}

	public void setData(List<ListItemEntity> data) {
		this.data = data;
	}
	
	
}