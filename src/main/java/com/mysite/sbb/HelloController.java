package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		// Spring Boot Framework 에 helloController 빈 등록
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World - My web Site";
	}
}
