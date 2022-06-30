package dec.text;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.alibaba.fastjson.JSONObject;

@FeignClient(name = "lzkfwt-dataaccess",fallback = DataExchangeDownMsgFallback.class)
public interface DataExchangeDownMsgInterface {

	@PostMapping("/command")
	public String downMsg(@RequestBody JSONObject downjson);
}
