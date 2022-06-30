package dataaccess.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.netty.channel.ChannelHandlerContext;

@RestController
public class DownCommandController {
	
	@PostMapping("/command")
	public String downCommand(@RequestBody JSONObject downjson) {
		System.out.println(downjson);
		String gid = downjson.getString("gid");
		String command = downjson.toJSONString();
		ChannelHandlerContext cxt = TestCache.cachemap.get(gid);
		cxt.writeAndFlush(command);
		return "write to device";
		
	}
}
