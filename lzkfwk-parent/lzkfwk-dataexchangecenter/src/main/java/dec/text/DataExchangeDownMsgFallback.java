package dec.text;

import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;

@Component
public class DataExchangeDownMsgFallback implements DataExchangeDownMsgInterface{

	@Override
	public String downMsg(JSONObject downjson) {
		
		return "fallback";
	}

}
