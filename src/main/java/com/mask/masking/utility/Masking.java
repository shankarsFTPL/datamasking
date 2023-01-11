package com.mask.masking.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mask.masking.entities.MaskFieldMapper;
import com.mask.masking.repositories.MaskMapperFieldRepository;
import com.mask.masking.repositories.MaskMapperRepository;

@Component
public class Masking {
	@Autowired
	MaskMapperRepository mapperRepo;
	@Autowired
	MaskMapperFieldRepository fieldRepo;
	
	
	public List<String> getMaskingFields(String entityName){
		
		return fieldRepo.findByMapperIdAndStatus(mapperRepo.findByMapperEntity(entityName),"A")
				.stream().map(MaskFieldMapper::getMapperEntityField)
				.collect(Collectors.toList());
	}
	

}
