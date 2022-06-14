package com.shop.spring_self.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_self.vo.ItemBasketVo;

public interface ItemBasketRepository extends CrudRepository<ItemBasketVo, Integer>{
	public Iterable<ItemBasketVo> findByMemberId(String memberId);
	public ItemBasketVo findByItemNumAndMemberId(int itemNum, String memberId);

	//없으면 0이 아니라 null이 나와서 참조형으로 return 
	public Integer countByMemberId(String memberId);
	
	@Query("SELECT SUM(basket.count) FROM ItemBasketVo basket WHERE basket.memberId=?1")
	public Integer sumCountByMemberId(String memberId);
	
}
