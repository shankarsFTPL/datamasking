package com.mask.masking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maskfieldmapper")
public class MaskFieldMapper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "maskmapperid")
	private Integer mapperId;
	
	@Column(name = "mapperentityfield")
	private String mapperEntityField;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMapperId() {
		return mapperId;
	}
	public void setMapperId(Integer mapperId) {
		this.mapperId = mapperId;
	}
	public String getMapperEntityField() {
		return mapperEntityField;
	}
	public void setMapperEntityField(String mapperEntityField) {
		this.mapperEntityField = mapperEntityField;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MaskFieldMapper [id=" + id + ", mapperId=" + mapperId + ", mapperEntityField=" + mapperEntityField
				+ ", status=" + status + "]";
	}
	
	
}
