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

import com.shop.spring_self.repository.BoardRepository;
import com.shop.spring_self.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardRepository br;
	
	@GetMapping("/list/{page}")
	public String pagealbeList(	@PathVariable int page,
								@RequestParam(defaultValue="num") String sort,
								@RequestParam(defaultValue="asc") String desc,
								Model model) {
		int size=5;
		Pageable pageable=null;
		if(desc.equals("desc")) {
			pageable=PageRequest.of(page-1, size,Sort.by(sort).descending());
		}else if(desc.equals("asc")) {
			pageable=PageRequest.of(page-1, size,Sort.by(sort).ascending());
		}
		Page<BoardVo> boardList=br.findAll(pageable);
		model.addAttribute("boardList",boardList);
		return "/board/pageableList";
	}
}
