package webservice.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private DataExchangeDownMsgInterface dedmf;
	
	@RequestMapping("/get")
	public String test(@RequestParam String id) {
		return "return value"+id;
	}
	
	@PostMapping("/command")
	public String downCommand(@RequestBody JSONObject downjson) {
		System.out.println(downjson.toJSONString());
		String s = dedmf.downMsg(downjson);
		return s;
		
	}
}
