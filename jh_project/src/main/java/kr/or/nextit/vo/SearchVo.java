package kr.or.nextit.vo;

import java.util.HashMap;
import java.util.Iterator;

public class SearchVo {

	private HashMap<String, Object> map = new HashMap<String, Object>();
	private String kind;
	
	public void setHashmap(HashMap<String, Object> searchDatas) {
		
		
		Iterator<String> itr = searchDatas.keySet().iterator();
		
		while(itr.hasNext()) {
			String name = itr.next();
			String value = (String)searchDatas.get(name);
			
			if(value == null || value.isEmpty()) continue;
			
			map.put(name, value);
			kind = value.equals("FREE") ? "FREE" : kind;
		}
	}

	public String getKind() {return kind;}

	@Override
	public String toString() {return map.toString() + "kind : " + kind;}
}
