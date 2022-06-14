package com.shop.spring_self.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.shop.spring_self.vo.MemberVo;


public interface MemberRepository extends CrudRepository<MemberVo, String>{
	public MemberVo findByIdAndPw(String id, String pw);
	public List<MemberVo> findAllByOrderByIdDesc();
	public List<MemberVo> findAllByOrderByIdAsc();
	public Optional<MemberVo> findByEmail(String email);
	public Optional<MemberVo> findByPhone(String phone);
	//JPQL는 vo Entity를 이요해서 쿼리를 작성한다. (db마다 쿼리 생성)
	@Query(value="SELECT mem FROM MemberVo mem WHERE mem.email=:email")
	public Optional<MemberVo> selectJPQLByEmail(@Param(value="email")String email);
	
	//natuveQuery 비권장 (JPQL로 할 수 없을 때, 특정 db에만 동작)
	@Query(value="SELECT * FROM member WHERE EMAIL=?1", nativeQuery=true)
	public Optional<MemberVo> selectByEmail(String email);
	public Page<MemberVo> findAll(Pageable pageable);
}
