package dataaccess.test;

import org.springframework.stereotype.Component;

@Component
public class TestFeignDataAnalyseFallback implements TestFeignDataAnalyseInf{

	@Override
	public String dataAnalyse(String obj) {
		return "turn error";
	}

}
