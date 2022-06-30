package dataanalyse.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestDataAnalyseController {

	@PostMapping("/dataAnalyse")
	public String dataAnalyse(@RequestBody String str) {
		System.out.println(str);
		return "return from TestDataAnalyseController";
	}
}
