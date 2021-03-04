package com.emobox.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emobox.spring01.model.dto.PointDTO;
import com.emobox.spring01.model.dto.ProductDTO;

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
	
	@RequestMapping("move.do")
	public String move() {
		//return "redirect:/result.do";
		return "redirect:/result.do?name=park&age=20";
	}
	
	@RequestMapping("result.do")
	public String reult(Model model,
			@RequestParam(defaultValue = "noname") String name,
			@RequestParam(defaultValue = "10") int age) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "test/result";
	}
	
	
	// 모델 & 뷰
	@RequestMapping("mav")
	public ModelAndView mav(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("사프",1000));
		// ModelAndView(url, key, value)
		return new ModelAndView("test/mav_result","map",map);
	}
	
	// Ajax 비동기
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax";
	}
	
	
	// URL (페이지로) 넘어가는게 아니고, 데이터 자체로 넘겨주는 것이다.
	// 그리고 사전 설정이 필요한게 있다.
	
	// {"key":"value"}
	// {"name":"냉장고","price":500000}
	@RequestMapping("background.do")
	public @ResponseBody ProductDTO background() {
		ProductDTO dto = new ProductDTO("냉장고", 500000);
		return dto;
	}
	
	
	@RequestMapping("login.do")
	public String login() {
		return "test/login";
	}
	
	
	@RequestMapping("login_result.do")
	public String login_result(@RequestParam String id,@RequestParam String pw, Model model) {
		
		String result="";
		
		if(id.equals("park") && pw.equals("1234")) {
			result = "환영합니다.";
		} else {
			result="아이디 또는 비밀번호가 틀렸습니다.";
		}
		
		model.addAttribute("result", result);
		return "test/login_result";
	}
	
	
	
	@RequestMapping("ajax_gugu.do")
	public String ajax_gugu() {
		return "test/ajax_gugu";
	}
	
	@RequestMapping("ajax_gugu_result.do")
	public String ajax_gugu_result(@RequestParam(defaultValue="3") int dan, Model model) {
		String result = "";
		for(int i=1; i<=9 ; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		
		model.addAttribute("result", result);
		return "test/ajax_gugu_result";
	}
	
	// http://hisoftlab.com/4432
	
	
}
