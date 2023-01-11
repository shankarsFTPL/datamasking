package com.mask.masking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maskmapper")
public class MaskMapper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "mapperentity")
	private String mapperEntity;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMapperEntity() {
		return mapperEntity;
	}
	public void setMapperEntity(String mapperEntity) {
		this.mapperEntity = mapperEntity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MaskMapper [id=" + id + ", mapperEntity=" + mapperEntity + ", status=" + status + "]";
	}
	
	
}
