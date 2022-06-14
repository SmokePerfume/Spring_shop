package com.shop.spring_self.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_self.vo.CategoryVo;



public interface CategoryRepository extends CrudRepository<CategoryVo, String>{
	
	public Page<CategoryVo> findAll(Pageable pageable);

}
