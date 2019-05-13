package kr.or.nextit.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.json.service.JsonVo;

@Controller
public class JsonFrontController {

	
	@RequestMapping(value="/json/testFront.do")
	public String jsonTestFront() throws Exception {
		
		
		return "json/testFront";
	}
	
	@ResponseBody
	@RequestMapping(value="/json/testData.json")
	public HashMap<String, Object> jsonTestData() throws Exception {
		
		HashMap<String, Object> result = new HashMap<>();
		
		result.put("name", "ddd");
		result.put("age", 50);
		result.put("title", "gg");
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		HashMap<String, Object> item = new HashMap<>();
		item.put("tel1", "0000");
		item.put("email", "2@2.com");
		list.add(item);
		
		result.put("info", list);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/json/testList.json")
	public List<HashMap<String, Object>> jsonTestList() throws Exception {
		
		List<HashMap<String, Object>> result = new ArrayList<>();
		HashMap<String, Object> item = new HashMap<>();
		item.put("name", "kjh");
		item.put("age", 150);
		item.put("title", "내곧제");
		
		
		result.add(item);
		
		item = new HashMap<>();
		item.put("name", "kjh");
		item.put("age", 150);
		item.put("title", "내곧제");
		
		result.add(item);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/json/testJsonVo.json")
	public JsonVo testJsonVo() throws Exception {
		
		JsonVo jsonVo = new JsonVo();
		
		jsonVo.setId("master");
		jsonVo.setName("홍gi;:");
		jsonVo.setStatus(true);
		jsonVo.setMessage("메시지다");
		
		List<Map<String, Object>> result = new ArrayList<>();
		HashMap<String, Object> item = new HashMap<>();
		item.put("name", "kjh");
		item.put("age", 150);
		item.put("title", "내곧제");
		
		result.add(item);
		
		jsonVo.setItem(result);
		
		return jsonVo;
	}
	
	
	
	
	
	
	
}
