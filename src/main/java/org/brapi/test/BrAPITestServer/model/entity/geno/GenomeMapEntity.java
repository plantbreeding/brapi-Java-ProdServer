package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.LongVarcharJdbcType;

@Entity
@Table(name="genome_map")
public class GenomeMapEntity extends BrAPIPrimaryEntity{
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String comments;
	@ManyToOne
	private CropEntity crop;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String documentationURL;
	@OneToMany(mappedBy="genomeMap")
	private List<LinkageGroupEntity> linkageGroups;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String mapName;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String mapPUI;
	@Column
	private Date publishedDate;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String scientificName;
	@ManyToMany
	@JoinTable
	private List<StudyEntity> studies;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String type;
	@Column
	@JdbcType(LongVarcharJdbcType.class)
    private String unit;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public CropEntity getCrop() {
		return crop;
	}
	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public List<LinkageGroupEntity> getLinkageGroups() {
		return linkageGroups;
	}
	public void setLinkageGroups(List<LinkageGroupEntity> linkageGroups) {
		this.linkageGroups = linkageGroups;
	}
	public String getMapName() {
		return mapName;
	}
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	public String getMapPUI() {
		return mapPUI;
	}
	public void setMapPUI(String mapPUI) {
		this.mapPUI = mapPUI;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
