package org.fmat.spring.security.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/sample")
	public String showSample() {
		return "sample";
	}

}
