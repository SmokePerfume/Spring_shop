package com.shop.spring_self.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_self.vo.ItemVo;

public interface ItemRepository extends CrudRepository<ItemVo, Integer>{
	@Query(value="SELECT item, mem, cate FROM ItemVo item "
			+ "LEFT JOIN MemberVo mem ON item.memberId=mem.id "
			+ "LEFT JOIN CategoryVo cate ON item.cateNum=cate.cateNum")
	public Iterable<Object[]> findAllWithCategoryWithMember();
	@EntityGraph(attributePaths= {"member","category"})
	public Iterable<ItemVo> findAllByOrderByPostTime();
	public Page<ItemVo> findAll(Pageable pageable);
}
