package com.mask.masking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mask.masking.entities.MaskFieldMapper;

public interface MaskMapperFieldRepository extends JpaRepository<MaskFieldMapper, Integer> {

	List<MaskFieldMapper> findByMapperIdAndStatus(Integer maskId,String status);


}
