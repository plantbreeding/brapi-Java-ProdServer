package org.brapi.test.BrAPITestServer.model.entity.germ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="breeding_method")
public class BreedingMethodEntity extends BrAPIPrimaryEntity {
	@Column
    @JdbcType(LongVarcharJdbcType.class)
    private String abbreviation;
    @Column
    @JdbcType(LongVarcharJdbcType.class)
    private String name;
    @Column
    @JdbcType(LongVarcharJdbcType.class)
    private String description;
    
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
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
        
}
