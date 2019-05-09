package kr.or.nextit.session.service;

import java.util.HashMap;

public interface SessionService {
	
	LoginInfoVo selectMemberInfo(HashMap<String, Object> params) throws Exception;
}
