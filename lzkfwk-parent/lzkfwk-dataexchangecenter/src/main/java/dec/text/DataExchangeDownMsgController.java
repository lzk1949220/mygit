package dec.text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/decDownMsg")
public class DataExchangeDownMsgController {
	
	@Autowired
	private DataExchangeDownMsgInterface dedmsg;

	@PostMapping("/command")
	public String downMsg(@RequestBody JSONObject downjson) {
		System.out.println(downjson.toJSONString());
		String s = dedmsg.downMsg(downjson);		
		return s;
		
	}
}
