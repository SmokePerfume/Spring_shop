package com.shop.spring_self.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_self.vo.BoardVo;

public interface BoardRepository extends CrudRepository<BoardVo, Integer>{
	public Page<BoardVo> findAll(Pageable pageable);

}
