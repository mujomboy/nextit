package kr.or.hello.service;

import java.util.HashMap;
import java.util.List;

public interface HelloService {

	public List<HashMap<String, Object>> getHelloList(
			String searchText
			) throws Exception;
	
	
}
