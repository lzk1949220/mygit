package dataaccess.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "lzkfwt-dataanalyse",fallback = TestFeignDataAnalyseFallback.class)
public interface TestFeignDataAnalyseInf {
	
	@RequestMapping(value = "/test/dataAnalyse", method = RequestMethod.POST)
	public String dataAnalyse(@RequestBody String obj);

}
