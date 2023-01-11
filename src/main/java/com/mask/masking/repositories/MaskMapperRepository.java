package com.mask.masking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mask.masking.entities.MaskMapper;

public interface MaskMapperRepository extends JpaRepository<MaskMapper, Integer> {

	@Query(value = "select * from maskmapper where mapperentity=?1", nativeQuery = true)
	Integer findByMapperEntity(String entityName);

}
