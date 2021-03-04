package com.emobox.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emobox.spring01.model.dao.MemberDAO;
import com.emobox.spring01.model.dto.MemberDTO;

@Controller // 추가 스프링에서 관리
public class MemberController {

	@Inject // 추가  스프링에서 관리 
	MemberDAO memberDao; // 추가 
	
	@RequestMapping("member/list.do") 
	public String list(Model model) {
		List<MemberDTO> list = memberDao.list();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	// 회원 폼으로 이ehd
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberDao.insert(dto);
		return "redirect:/member/list.do";
	}
	
}
