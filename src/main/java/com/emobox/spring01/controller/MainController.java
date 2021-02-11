package com.emobox.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emobox.spring01.model.dto.PointDTO;

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
	
	
	@RequestMapping("point.do")
	public String point() {
		return "point/point";
	}
	
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
//		double average = dto.getTotal()/3.0;
//		dto.setAverage(average);
		
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
		String average = String.format("%.2f", dto.getTotal()/3.0);
		dto.setAverage(Double.parseDouble(average));  // String to Double
		model.addAttribute("dto", dto);
		return "point/point_result";
	}
	
}
