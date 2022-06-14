package com.shop.spring_self.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.spring_self.repository.CategoryRepository;
import com.shop.spring_self.vo.CategoryVo;

@Controller
@RequestMapping("/cate")
public class CategoryController {
	@Autowired
	CategoryRepository cr;
	@GetMapping("/list.do")
	public String list(Model model) {
		Iterable<CategoryVo> cateList=cr.findAll();
		model.addAttribute("cateList",cateList); 
		System.out.println(cateList);
		return "cate/list";
	}
	@GetMapping("/list/{page}")
	public String pageableList(@PathVariable int page,
			@RequestParam(defaultValue = "cateNum") String sort,
			@RequestParam(defaultValue = "desc") String desc, 
			Model model) {
		int size=5;
		Pageable pageable=null;
		if(desc.equals("desc")){
			pageable=PageRequest.of(page-1, size,Sort.by(sort).descending()); //mysql limit(start, size)
		}else if(desc.equals("asc")){
			pageable=PageRequest.of(page-1, size,Sort.by(sort).ascending()); //mysql limit(start, size)
		}
		
		
		
		Page<CategoryVo> cateList=cr.findAll(pageable);
		
		System.out.println("화면에 출력할 size: "+cateList.getSize());
		System.out.println("총 page 수: "+cateList.getTotalPages());
		System.out.println("현제 페이지의 다음이 있는지?: "+cateList.hasNext());
		System.out.println("현제 페이지의 이전이 있는지?: "+cateList.hasPrevious());
		System.out.println("total row: "+cateList.getTotalElements());
		System.out.println("현재 패이지: "+cateList.getNumber()+1);
		
		model.addAttribute("cateList",cateList);
		return "/cate/pageableList";
	}
}
