package kr.or.hello.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.or.hello.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public List<HashMap<String, Object>> getHelloList(String searchText) throws Exception {

		List<HashMap<String, Object>> result = new ArrayList<>();
		
		HashMap<String, Object> item = new HashMap<>();
		
		
		item.put("id", "master");
		item.put("name", "곽정호");
		item.put("age", 15);
		result.add(item);
		
		item = new HashMap<>();
		item.put("id", "admin");
		item.put("name", "김정호");
		item.put("age", 152);
		result.add(item);
		
		item = new HashMap<>();
		item.put("id", "admin");
		item.put("name", "이정호");
		item.put("age", 150);
		result.add(item);
		
		return result;
	}

}
