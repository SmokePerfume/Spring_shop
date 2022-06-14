package com.shop.spring_self.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.spring_self.repository.ItemBasketRepository;
import com.shop.spring_self.vo.ItemBasketVo;
import com.shop.spring_self.vo.MemberVo;

@Controller
@RequestMapping("/itemBasket")
public class ItemBasketController {
	@Autowired
	ItemBasketRepository ibr;
	
	@GetMapping("/list.do")
	public String list(Model model, HttpSession session) {
		MemberVo memVo=(MemberVo)session.getAttribute("memVo"); //기존 세션의 정보 가져오기
		model.addAttribute("basketList",ibr.findByMemberId(memVo.getId()));
		return "/itemBasket/list";
	}
	
	@PostMapping("/insert.do")
	public String insert(int itemNum,int count,HttpSession session) {
		MemberVo memVo=(MemberVo)session.getAttribute("memVo");
		ItemBasketVo basketVo=ibr.findByItemNumAndMemberId(itemNum, memVo.getId());
		if(basketVo==null) { 
			basketVo=new ItemBasketVo();
			basketVo.setMemberId(memVo.getId());
			basketVo.setItemNum(itemNum);
			basketVo.setCount(count);
			ibr.save(basketVo); 
		}else {
			basketVo.setCount(basketVo.getCount()+count);
			ibr.save(basketVo);  
		}
		return "redirect:/itemBasket/list.do";
	}
	
	@PostMapping("/update.do")
	public String update(ItemBasketVo basketVo) {
		ibr.save(basketVo);
		return "redirect:/itemBasket/list.do";
	}
	
	@PostMapping("/delete.do")
	public String delete(ItemBasketVo basketVo) {
		ibr.delete(basketVo);
		return "redirect:/itemBasket/list.do";
	}
}
