package com.emobox.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/") // Url Mapping 
	public String main(Model model) {
		model.addAttribute("name","박기용");
		model.addAttribute("message","홈페이지 방문을 환영합니다.");
		return "main";
	}
	
	@RequestMapping("gugu.do") // Url Mapping 
	public String write(){
		return "gugu/gugu";
	}	
	
	@RequestMapping("gugu_result.do")
	public String gugu(@RequestParam(defaultValue = "3") int dan, Model model) {
		String result = "";
		for (int i = 1 ; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		
		}
		model.addAttribute("result", result);
		return "gugu/gugu_result";
	}
}
